package com.uber.demo.controller;

import com.uber.demo.beans.Order;
import com.uber.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService= orderService;
    }

    @GetMapping("/order/read/{id}")
    public Order read(@PathVariable("id")Long id){
        return orderService.read(id);
    }

    @PostMapping("/order/Create")
    public Order create(@Valid Order order){
        return orderService.create(order);
    }

    @GetMapping("/order/readAll")
    @ResponseBody
    public List<Order> readAll(){
        return orderService.readAll();
    }

    @PatchMapping("/order/update/{id}")
    public Order update(@PathVariable("id") Long id) {
        return orderService.update(id);
    }

    @DeleteMapping("/order/delete/{id}")
    public Order delete(@PathVariable("id")Long id) {
        return orderService.delete(id);
    }

}
