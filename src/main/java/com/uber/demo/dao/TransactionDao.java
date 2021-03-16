package com.uber.demo.dao;


import com.uber.demo.batchStmt.TransactionBatchPreparedStatement;
import com.uber.demo.beans.Transaction;
import com.uber.demo.preparedStmtCallBack.TransactionCallBack;
import com.uber.demo.rowMapper.TransactionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TransactionDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public TransactionDao(JdbcTemplate jdbcTemplate,NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }

    public Transaction show(long id) {
        return jdbcTemplate.query("SELECT * FROM \"transaction\" WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Transaction.class))
                .stream().findAny().orElse(null);
    }

    public List<Transaction> getAllTransactions() {
        return jdbcTemplate.query("SELECT * FROM \"transaction\"", new TransactionRowMapper());
    }

    public Transaction saveTransaction(Transaction transactions) {
        String query = "insert into \"transaction\" values (:id,:client_id,:taxi_id,:from_id)";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", transactions.getId());
        parameters.put("client_id", transactions.getOrder_id());
        parameters.put("taxi_id", transactions.getTransactionStatus());
        parameters.put("from_id", transactions.getPay_date());
        namedParameterJdbcTemplate.execute(query, parameters, new TransactionCallBack());
        return transactions;
    }

    public Transaction getTransaction(final long id) {
        final String query = "SELECT * FROM \"transaction\" WHERE ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new TransactionRowMapper());
    }


    public Transaction updateTransaction(long id) {
        Transaction transaction=getTransaction(id);
        jdbcTemplate.batchUpdate("INSERT INTO \"transaction\" VALUES (?, ?, ?, ?)", new TransactionBatchPreparedStatement(transaction));
        return transaction;
    }

    public Transaction deleteTransaction(long id) {
        Transaction transactions=getTransaction(id);
        String SQL = "delete from \"transaction\" where id = ?";
        jdbcTemplate.update(SQL, id);
        return transactions;
    }
}
