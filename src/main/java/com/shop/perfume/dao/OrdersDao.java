package com.shop.perfume.dao;

import com.shop.perfume.model.Member;
import com.shop.perfume.model.Orders;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface OrdersDao extends CrudRepository<Orders, Integer> {

  Optional<Orders> getOrdersByOrderId(long orderId);

}
