package com.shop.perfume.controller;

import com.shop.perfume.model.Member;
import com.shop.perfume.model.Orders;
import com.shop.perfume.service.MemberService;
import com.shop.perfume.service.OrdersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

  final String API_PREFIX = "/perfume";
  final String API_GET_ALL_ORDERS = API_PREFIX + "/orders/"; //登入

  @Autowired
  private OrdersService ordersService;

  @GetMapping(value = API_GET_ALL_ORDERS)
  public ResponseEntity<List<Orders>> listAllOrders() {
    List<Orders> orders = ordersService.getAllOrders();
    if (orders.isEmpty()) {
      return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(orders, HttpStatus.OK);
  }

  @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET, produces =
      MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Orders> getOrder(@PathVariable("orderId") String orderId) {
    Orders order = ordersService.getOrderById(orderId);
    if (order == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(order, HttpStatus.OK);
  }


  @RequestMapping(value = "/order/", method = RequestMethod.POST)
  public ResponseEntity<Orders> createOrder(@RequestBody Orders orderFe) {
    return new ResponseEntity<Orders>(ordersService.createOrder(orderFe), HttpStatus.OK);
  }

  @RequestMapping(value = "/order/update/", method = RequestMethod.POST)
  public ResponseEntity<Orders> UpdateOrder(@RequestBody Orders orderFe) {
    return new ResponseEntity<Orders>(ordersService.updateOrder(orderFe), HttpStatus.OK);
  }

  @RequestMapping(value = "/order/{orderId}", method = RequestMethod.DELETE)
  public ResponseEntity<Orders> deleteOrder(@PathVariable("orderId") String orderId) {
    Orders order = ordersService.getOrderById(orderId);
    if (order == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    ordersService.deleteOrder(order);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
