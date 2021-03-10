package com.shop.perfume.dao;

import com.shop.perfume.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberDao extends CrudRepository<Member, Integer> {

  Member findMemberByMemberID(String memberID);
}
