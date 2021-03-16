package com.uber.demo.batchStmt;

import com.uber.demo.beans.Order;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderBatchPreparedStatement implements BatchPreparedStatementSetter {
    private final Order order;

    public OrderBatchPreparedStatement(Order order) {
        this.order = order;
    }

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
//        ps.setLong(1, order.getId());
        ps.setLong(1, (order.getClient_id()));
        ps.setLong(2, (order.getTaxi_id()));
        ps.setLong(3, order.getFrom_id());
        ps.setLong(4, order.getTo_id());
        ps.setString(5, order.getStatus().toString());
        ps.setTimestamp(6, order.getOrder_date());
    }

    @Override
    public int getBatchSize() {
        return 6;
    }
}