package com.shop.perfume.service.impl;

import com.shop.perfume.dao.MemberDao;
import com.shop.perfume.dao.OrdersDao;
import com.shop.perfume.model.Member;
import com.shop.perfume.model.Orders;
import com.shop.perfume.service.MemberService;
import com.shop.perfume.service.OrdersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

  @Autowired
  OrdersDao ordersDao;

  @Override
  public List<Orders> getAllOrders() {
    return (List<Orders>) ordersDao.findAll();
  }

  @Override
  public Orders getOrderById(String orderId) {
    return ordersDao.getOrdersByOrderId(Integer.parseInt(orderId))
        .orElseThrow(() ->
            new RuntimeException("Order not found => OrderID : " + orderId));
  }

//  @Override
//  public Orders getMemberByEmail(String email) {
//    return ordersDao.findAllById(email).orElseThrow(() ->
//        new RuntimeException("Order not found => Email : " + email));
//  }

  @Override
  public Orders createOrder(Orders order) {
    return ordersDao.save(order);
  }

  @Override
  public Orders updateOrder(Orders order) {
    return null;
  }

  @Override
  public void deleteOrder(Orders order) {
    ordersDao.delete(order);
  }
}
