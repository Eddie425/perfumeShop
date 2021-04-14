package com.shop.perfume.admin.controller;

import com.shop.perfume.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

  @Autowired
  OrdersService ordersService;

  @GetMapping("/home")
  public String home(Model model) {
    model.addAttribute("orders", ordersService.getAllOrders());
    return "home";
  }

}
