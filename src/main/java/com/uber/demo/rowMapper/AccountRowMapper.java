package com.uber.demo.rowMapper;

import com.uber.demo.beans.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int i) throws SQLException {
        final Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setFirstName(rs.getString("first_name"));
        account.setLastName(rs.getString("last_name"));
        account.setUserName(rs.getString("username"));
        account.setEmail(rs.getString("email"));
        account.setPassword(rs.getString("password"));
        account.setUserType(rs.getString("user_type"));
        return account;
    }

}
