package com.shop.perfume.controller;

import com.shop.perfume.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

//  @Autowired
//  private MemberDao memberDao;
//
//  @PostMapping("/add")
//  public String addCustomer(@RequestParam String first, @RequestParam String last) {
//    Customer customer = new Customer();
//    customer.setFirstName(first);
//    customer.setLastName(last);
//    customerRepository.save(customer);
//    return "Added new customer to repo!";
//  }
//
//  @GetMapping("/list")
//  public Iterable<Customer> getCustomers() {
//    return customerRepository.findAll();
//  }
//
//  @GetMapping("/find/{id}")
//  public Customer findCustomerById(@PathVariable Integer id) {
//    return customerRepository.findCustomerById(id);
//  }
}
