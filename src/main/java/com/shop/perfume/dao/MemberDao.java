package com.shop.perfume.dao;

import com.shop.perfume.model.Member;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface MemberDao extends CrudRepository<Member, Integer> {

  Optional<Member> findByMemberId(long memberId);
  Optional<Member> findByEmail(String email);

  Page<Member> findByEmailContains(String email, Pageable pageable);
  Page<Member> findAllByEmail(String email, Pageable pageable);
  Page<Member> findAllByEmailContainsAndEmail(String email, String auth, Pageable pageable);

  Boolean existsByEmail(String email);
}
