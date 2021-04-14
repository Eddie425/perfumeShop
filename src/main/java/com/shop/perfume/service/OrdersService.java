package com.shop.perfume.service;

import com.shop.perfume.model.Orders;
import java.util.List;

public interface OrdersService {

  List<Orders> getAllOrders();
  Orders getOrderById(String ordersId);

  Orders createAndPlaceOrder(Orders order);

  Orders updateOrder(Orders order);

  void deleteOrder(Orders order);
}




