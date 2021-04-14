package com.shop.perfume.controller.impl;

import com.shop.perfume.controller.MemberController;
import com.shop.perfume.controller.OrdersController;
import com.shop.perfume.model.Member;
import com.shop.perfume.model.Orders;
import com.shop.perfume.service.MemberService;
import com.shop.perfume.service.OrdersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class MemberControllerImpl implements MemberController {

  @Autowired
  private MemberService memberService;

  /**
   *
   * @return 取的所有會員資料
   */
  @Override
  public ResponseEntity<List<Member>> listAllMembers() {
    List<Member> members = memberService.getAllMembers();
    if (members.isEmpty()) {
      return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(members, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Member> createMember(@RequestBody Member memberFe) {
    return new ResponseEntity<Member>(memberService.createMember(memberFe), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Member> getMemberById(@PathVariable("memberId") String memberId) {
    Member member = memberService.getMemberById(memberId);
    if (member == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(member, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Member> updateMember(@RequestBody Member memberFe) {
    return new ResponseEntity<Member>(
        memberService.updateMember(memberFe), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Member> deleteMemberById(@PathVariable("memberId") String memberId) {
    Member member = memberService.getMemberById(memberId);
    if (member == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    memberService.deleteMember(member);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
