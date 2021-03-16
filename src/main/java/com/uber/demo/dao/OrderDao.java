package com.uber.demo.dao;

import com.uber.demo.batchStmt.OrderBatchPreparedStatement;
import com.uber.demo.beans.Order;
import com.uber.demo.preparedStmtCallBack.OrderCallBack;
import com.uber.demo.rowMapper.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderDao {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate,NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }


    public Order show(long id) {
        return jdbcTemplate.query("SELECT * FROM \"order\" WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Order.class))
                .stream().findAny().orElse(null);
    }
    public List<Order> getAllOrders() {
        return jdbcTemplate.query("SELECT * FROM \"order\"", new OrderRowMapper());
    }

    public Order saveOrder(Order order) {
        String query = "insert into \"order\" values (:id,:client_id,:taxi_id,:from_id,:to_id,:status,:order_date)";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", order.getId());
        parameters.put("client_id", order.getClient_id());
        parameters.put("taxi_id",order.getTaxi_id());
        parameters.put("from_id" ,order.getFrom_id());
        parameters.put("to_id",order.getTo_id());
        parameters.put("status",order.getStatus());
        parameters.put("order_date",order.getOrder_date());
        namedParameterJdbcTemplate.execute(query, parameters, new OrderCallBack());
        return order;
    }
    public Order deleteOrder(long id){
        Order order=getOrder(id);
        String SQL = "delete from \"order\" where id = ?";
        jdbcTemplate.update(SQL, id);
        return order;
    }

    public Order getOrder(final long id) {
        final String query = "SELECT * FROM \"order\" WHERE ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { id }, new OrderRowMapper());
    }


    public Order updateOrder(final Order order) {
        jdbcTemplate.batchUpdate("INSERT INTO \"order\" VALUES (?, ?, ?, ?, ? ,?)", new OrderBatchPreparedStatement(order));
        return order;
    }
}
