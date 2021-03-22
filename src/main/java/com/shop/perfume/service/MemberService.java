package com.shop.perfume.service;

import com.shop.perfume.model.Member;
import java.util.List;

public interface MemberService {

  List<Member> getAllUsers();

  Member getMemberById(String memberID);

  Member getMemberByEmail(String email);

  Member createUser(Member member);

  void deleteUserByMemberID(String memberID);

}
