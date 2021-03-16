package com.uber.demo.rowMapper;

import com.uber.demo.beans.Order;
import com.uber.demo.enums.OrderStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        final Order order=new Order();
        order.setId(resultSet.getLong("id"));
        order.setClient_id(resultSet.getLong("client_id"));
        order.setTaxi_id(resultSet.getLong("taxi_id"));
        order.setFrom_id(resultSet.getLong("from_id"));
        order.setTo_id(resultSet.getLong("to_id"));
        order.setStatus(OrderStatus.valueOf(resultSet.getString("status")));
        order.setOrder_date(resultSet.getTimestamp("order_date"));
        return order;
    }
}
