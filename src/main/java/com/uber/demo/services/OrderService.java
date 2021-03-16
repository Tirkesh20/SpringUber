package com.uber.demo.services;



import com.uber.demo.beans.Order;
import com.uber.demo.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService extends ServiceInterface<Order>{
    private final OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> readAll(){
        return orderDao.getAllOrders();
    }

    public Order read(long id){return orderDao.getOrder(id);}

    @Override
    public Order update(long id) {
        return orderDao.deleteOrder(id);
    }

    public Order create(Order entity){
        return orderDao.saveOrder(entity);
    }

    @Override
    public Order delete(long id) {
        return orderDao.deleteOrder(id);
    }
}

