package com.shop.perfume.service.impl;

import com.shop.perfume.dao.OrdersDao;
import com.shop.perfume.model.Orders;
import com.shop.perfume.service.OrdersService;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    return ordersDao.findById(Integer.parseInt(orderId))
        .orElseThrow(() ->
            new RuntimeException("Order not found => OrderID : " + orderId));
  }

  @Override
  public Orders createAndPlaceOrder(Orders order) {
    AllInOne allInOne = new AllInOne("src/main/resources");
    AioCheckOutALL aioCheckOutALL = new AioCheckOutALL();
    return ordersDao.save(order);
  }

  @Override
  public Orders updateOrder(Orders order)  {
    return ordersDao.save(order);
  }

  @Override
  public void deleteOrder(Orders order) {
    ordersDao.delete(order);
  }
}
