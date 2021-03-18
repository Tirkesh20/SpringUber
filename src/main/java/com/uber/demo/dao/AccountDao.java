package com.uber.demo.dao;

import com.uber.demo.batchStmt.AccountBatchPreparedStatement;
import com.uber.demo.beans.Account;
import com.uber.demo.preparedStmtCallBack.AccountCallBack;
import com.uber.demo.rowMapper.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AccountDao {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public AccountDao(JdbcTemplate jdbcTemplate,NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }

    public Account accountCheck(Account account) {
        return jdbcTemplate.query("SELECT * FROM account WHERE username=? and password=?", new Object[]{account.getUsername(),account.getPassword()}, new BeanPropertyRowMapper<>(Account.class))
                .stream().findAny().orElse(null);
    }

    public List<Account> getAllAccounts() {
        return jdbcTemplate.query("SELECT * FROM account", new BeanPropertyRowMapper<>(Account.class));
    }




    public Account getAccount(final long id) {
        final String query = "SELECT * FROM account WHERE ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new AccountRowMapper());
    }

    public String getEmployeeUsingMapSqlParameterSource() {
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("id", 1);
        return namedParameterJdbcTemplate.queryForObject("SELECT first_name FROM account WHERE ID = :id", sqlParameterSource, String.class);
    }

    public Account updateAccount(long id) {
        Account account=getAccount(id);
        jdbcTemplate.batchUpdate("UPDATE account set first_name=?,last_name=?,username=?,email=?,password=?,user_type=? where id=?", new AccountBatchPreparedStatement(account));
        return account;
    }
    public Account deleteAccount(long id){
        Account account=getAccount(id);
        String SQL = "delete from account where id = ?";
        jdbcTemplate.update(SQL, id);
        return account;
    }
    public Account saveAccount(Account account) {
        String query = "insert into account values (:id,:first_name,:last_name,:username,:email,:password,:user_type)";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",account.getId());
        map.put("first_name", account.getFirstName());
        map.put("last_name", account.getLastName());
        map.put("username", account.getUsername());
        map.put("email", account.getEmail());
        map.put("password", account.getPassword());
        map.put("user_type", account.getUserType().toString());
        namedParameterJdbcTemplate.execute(query, map,new AccountCallBack());
        return account;
    }
}
