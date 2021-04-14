package com.shop.perfume.dao;

import com.shop.perfume.model.Orders;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrdersDao extends PagingAndSortingRepository<Orders, Integer> {

}
