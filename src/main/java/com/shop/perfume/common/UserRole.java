package com.shop.perfume.common;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

  ADMIN("ADMIN", 0),
  MEMBER("MEMBER", 1);

  private String userType;
  private Integer userCode;

  public static UserRole findByCode(Integer userCode) {
    for (UserRole role : UserRole.values()) {
      if (Objects.equals(role.getUserCode(), userCode)) {
        return role;
      }
    }
    return null;
  }

}
