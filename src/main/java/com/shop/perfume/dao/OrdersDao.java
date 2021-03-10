package com.shop.perfume.dao;

import com.shop.perfume.model.Orders;
import com.shop.perfume.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface OrdersDao extends CrudRepository<Orders, Integer> {

  Orders findOrderByOrderID(Integer id);
}
