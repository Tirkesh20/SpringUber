package com.uber.demo.batchStmt;

import com.uber.demo.beans.Transaction;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionBatchPreparedStatement implements BatchPreparedStatementSetter {
    private final Transaction transaction;

    public TransactionBatchPreparedStatement(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setLong(1, transaction.getId());
        ps.setLong(2, transaction.getOrder_id());
        ps.setString(3, transaction.getTransactionStatus().toString());
        ps.setTimestamp(4, transaction.getPay_date());
    }

    @Override
    public int getBatchSize() {
        return 4;
    }
}
