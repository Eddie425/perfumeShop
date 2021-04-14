package com.shop.perfume.service.impl;

import com.shop.perfume.controller.impl.MemberControllerImpl;
import com.shop.perfume.dao.MemberDao;
import com.shop.perfume.model.Member;
import com.shop.perfume.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  MemberDao memberDao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private MemberControllerImpl memberController;

  @Override
  public List<Member> getAllMembers() {
    return (List<Member>) memberDao.findAll();
  }

  @Override
  public Member createMember(Member member) {
    member.setPassword(passwordEncoder.encode(member.getPassword()));
    return memberDao.save(member);
  }

  @Override
  public Member getMemberById(String memberId) {
    return memberDao.findByMemberId(Integer.parseInt(memberId))
        .orElseThrow(() ->
            new RuntimeException("Member not found => memberID : " + memberId));
  }

  @Override
  public Member updateMember(Member member) {
    return memberDao.save(member);
  }

  @Override
  public Member getMemberByEmail(String email) {
    return memberDao.findByEmail(email).orElseThrow(() ->
        new RuntimeException("Member not found => Email : " + email));
  }

  @Override
  public void deleteMember(Member member) {
    memberDao.delete(member);
  }
}
