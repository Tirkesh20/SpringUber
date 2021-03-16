package com.uber.demo.beans;


import com.uber.demo.enums.OrderStatus;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@Component("Order")
public class Order {
    private long id;
    private long client_id;
    private long taxi_id;
    private long from_id;
    private long to_id;
    private Timestamp order_date = new Timestamp(System.currentTimeMillis());
    private OrderStatus status = OrderStatus.WAITING;

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }
    public long getClient_id() {
        return client_id;
    }
    public long getFrom_id() {
        return from_id;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getTaxi_id() {
        return taxi_id;
    }
    public void setTaxi_id(long taxi_id) {
        this.taxi_id = taxi_id;
    }
    public long getTo_id() {
        return to_id;
    }
    public void setTo_id(long to_id) {
        this.to_id = to_id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setFrom_id(long from_id) {
        this.from_id = from_id;
    }

    public Timestamp getOrder_date() {
        return order_date;

    }
    public void setOrder_date(Timestamp order_date){
        this.order_date=order_date;
    }
}