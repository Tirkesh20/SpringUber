package com.uber.demo.batchStmt;

import com.uber.demo.beans.Account;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountBatchPreparedStatement implements BatchPreparedStatementSetter {

    private final Account account;

    public AccountBatchPreparedStatement(Account account) {
        this.account = account;
    }

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setLong(1, account.getId());
        ps.setString(2, account.getFirstName());
        ps.setString(3, account.getLastName());
        ps.setString(4, account.getUsername());
        ps.setString(5, account.getEmail());
        ps.setString(6, account.getPassword());
        ps.setString(7, account.getUserType().toString());
    }

    @Override
    public int getBatchSize() {
        return 7;
    }
}
