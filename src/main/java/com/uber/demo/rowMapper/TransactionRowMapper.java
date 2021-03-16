package com.uber.demo.rowMapper;

import com.uber.demo.beans.Transaction;
import com.uber.demo.enums.TransactionStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        final Transaction transactions=new Transaction();
        transactions.setId(resultSet.getLong("id"));
        transactions.setOrder_id(resultSet.getLong("order_id"));
        transactions.setTransactionStatus(TransactionStatus.valueOf(resultSet.getString("status")));
        transactions.setPay_date(resultSet.getTimestamp("pay_date"));
        return transactions;
    }
}