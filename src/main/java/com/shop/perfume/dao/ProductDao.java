package com.shop.perfume.dao;

import com.shop.perfume.model.Member;
import com.shop.perfume.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {

  Product findProductByProductID(String productID);
}
