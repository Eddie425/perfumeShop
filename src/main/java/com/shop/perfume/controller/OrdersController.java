package com.shop.perfume.controller;

import com.shop.perfume.model.Member;
import com.shop.perfume.model.Orders;
import com.shop.perfume.service.MemberService;
import com.shop.perfume.service.OrdersService;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OrdersController extends AspectController {

  String API_PREFIX = API_PERFUME + "/orders";

  String API_ORDERS = API_PREFIX + "/";
  String API_ORDER_AND_ORDER_ID = API_PREFIX + "/{orderId}";
  String API_UPDATE_ORDER = API_PREFIX + "/update/";


  @GetMapping(value = API_ORDERS)
  default ResponseEntity<List<Orders>> listAllOrders() {
    return new ResponseEntity<>(
        Collections.singletonList(
            Orders.builder().build()), HttpStatus.OK);
  }

  @GetMapping(value = API_ORDER_AND_ORDER_ID,
      produces = MediaType.APPLICATION_JSON_VALUE)
  default ResponseEntity<Orders> getOrder(
      @PathVariable("orderId") String orderId) {
    return new ResponseEntity<>(Orders.builder().build(), HttpStatus.OK);
  }

  @PostMapping(value = API_ORDERS)
  default ResponseEntity<Orders> createOrder(@RequestBody Orders orderFe) {
    return new ResponseEntity<>(Orders.builder().build(), HttpStatus.OK);
  }

  @PostMapping(value = API_UPDATE_ORDER)
  default ResponseEntity<Orders> UpdateOrder(@RequestBody Orders orderFe) {
    return new ResponseEntity<>(Orders.builder().build(), HttpStatus.OK);
  }

  @DeleteMapping(value = API_ORDER_AND_ORDER_ID)
  default ResponseEntity<Orders> deleteOrder(@PathVariable("orderId") String orderId) {
    return new ResponseEntity<>(Orders.builder().build(), HttpStatus.OK);
  }
}
