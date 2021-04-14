package com.shop.perfume.controller.impl;

import com.shop.perfume.controller.OrdersController;
import com.shop.perfume.model.Orders;
import com.shop.perfume.service.OrdersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class OrdersControllerImpl implements OrdersController {

  @Autowired
  private OrdersService ordersService;

  @Override
  public ResponseEntity<List<Orders>> listAllOrders() {
    List<Orders> orders = ordersService.getAllOrders();
    if (orders.isEmpty()) {
      return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(orders, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Orders> getOrder(String orderId) {
    Orders order = ordersService.getOrderById(orderId);
    if (order == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(order, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Orders> createOrder(Orders orderFe) {
    return new ResponseEntity<Orders>(
        ordersService.createOrder(orderFe), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Orders> UpdateOrder(Orders orderFe) {
    return new ResponseEntity<Orders>(
        ordersService.updateOrder(orderFe), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Orders> deleteOrder(String orderId) {
    Orders order = ordersService.getOrderById(orderId);
    if (order == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    ordersService.deleteOrder(order);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
