package com.shop.perfume.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

//  @GetMapping("/")
//  public String home() {
//    return "Hello World!";
//  }

  @GetMapping("/api/test")
  public String apiTest() {
    System.out.println("HERE");
    return "Perfume Shop";
  }
}
