package com.shop.perfume.service;

import com.shop.perfume.model.Member;
import java.util.List;

public interface MemberService {

  List<Member> getAllMembers();

  Member getMemberById(String memberId);

  Member getMemberByEmail(String email);

  Member createMember(Member member);

  Member updateMember(Member member);

  void deleteMember(Member member);

}
