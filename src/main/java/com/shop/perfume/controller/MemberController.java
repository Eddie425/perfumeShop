package com.shop.perfume.controller;

import com.shop.perfume.model.Member;
import com.shop.perfume.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

  @Autowired
  private MemberService memberService;

  @RequestMapping(value = "/user/", method = RequestMethod.GET)
  public ResponseEntity<List<Member>> listAllUsers() {
    List<Member> members = memberService.getAllUsers();
    if (members.isEmpty()) {
      return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(members, HttpStatus.OK);
  }

  @RequestMapping(value = "/user/{memberID}", method = RequestMethod.GET, produces =
      MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Member> getUser(@PathVariable("memberID") String memberID) {
    Member member = memberService.getMemberById(memberID);
    if (member == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(member, HttpStatus.OK);
  }


  @RequestMapping(value = "/user/", method = RequestMethod.POST)
  public ResponseEntity<Member> createUser(@RequestBody Member memberFe) {
    return new ResponseEntity<Member>(memberService.createUser(memberFe), HttpStatus.OK);
  }

  @RequestMapping(value = "/user/{memberID}", method = RequestMethod.DELETE)
  public ResponseEntity<Member> deleteUser(@PathVariable("memberID") String memberID) {
    Member user = memberService.getMemberById(memberID);
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    memberService.deleteUserByMemberID(memberID);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
