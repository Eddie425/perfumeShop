package com.shop.perfume.service.impl;

import com.shop.perfume.dao.MemberDao;
import com.shop.perfume.model.Member;
import com.shop.perfume.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  MemberDao memberDao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public List<Member> getAllUsers() {
    return (List<Member>) memberDao.findAll();
  }

  @Override
  public Member getMemberById(String memberId) {
    return memberDao.findByMemberId(Integer.parseInt(memberId))
        .orElseThrow(() ->
            new RuntimeException("Member not found => memberID : " + memberId));
  }

  @Override
  public Member getMemberByEmail(String email) {
    return memberDao.findByEmail(email).orElseThrow(() ->
        new RuntimeException("Member not found => Email : " + email));
  }

  @Override
  public Member createUser(Member member) {
    member.setPassword(passwordEncoder.encode(member.getPassword()));
    return memberDao.save(member);
  }

  @Override
  public void deleteUserByMemberID(String memberId) {
    memberDao.delete(memberDao.findByMemberId(Integer.parseInt(memberId)).orElseThrow(() ->
        new RuntimeException("Member not found => memberID : " + memberId)));
  }
}
