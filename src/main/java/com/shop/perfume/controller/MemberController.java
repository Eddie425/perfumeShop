package com.shop.perfume.controller;

import com.shop.perfume.model.Member;
import com.shop.perfume.model.Orders;
import com.shop.perfume.service.MemberService;
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
public interface MemberController extends AspectController {

  String API_PREFIX = API_PERFUME + "/member";

  String API_MEMBERS = API_PREFIX + "/";
  String API_MEMBER_CREATE = API_PREFIX + "/";
  String API_MEMBER_GET_BY_ID = API_PREFIX + "/{memberId}";
  String API_MEMBER_DELETE_BY_ID = API_PREFIX + "/{memberId}";
  String API_MEMBER_UPDATE = API_PREFIX + "/update/";


  @GetMapping(value = API_MEMBERS)
  default ResponseEntity<List<Member>> listAllMembers() {
    return new ResponseEntity<>(
        Collections.singletonList(
            Member.builder().build()), HttpStatus.OK);
  }

  @PostMapping(value = API_MEMBER_CREATE)
  default ResponseEntity<Member> createMember(@RequestBody Member memberFe) {
    return new ResponseEntity<>(Member.builder().build(), HttpStatus.OK);
  }

  @GetMapping(value = API_MEMBER_GET_BY_ID,
      produces = MediaType.APPLICATION_JSON_VALUE)
  default ResponseEntity<Member> getMemberById(@PathVariable("memberId") String memberId) {
    return new ResponseEntity<>(Member.builder().build(), HttpStatus.OK);
  }

  @PostMapping(value = API_MEMBER_UPDATE)
  default ResponseEntity<Member> updateMember(@RequestBody Member memberFe) {
    return new ResponseEntity<>(Member.builder().build(), HttpStatus.OK);
  }

  @DeleteMapping(value = API_MEMBER_DELETE_BY_ID)
  default ResponseEntity<Member> deleteMemberById(@PathVariable("memberId") String memberId) {
    return new ResponseEntity<>(Member.builder().build(), HttpStatus.OK);
  }
}
