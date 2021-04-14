package com.shop.perfume.model;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long memberId;

    @Basic(fetch = FetchType.LAZY)
    private String password;

    private String firstName;

    private String lastName;

    private String gender;

    private String dateOfBirth;

    private String email;

    private String phone;

    private String postalCode;

    private String city;

    private String district;

    private String address;

    private String memberImage;

    private LocalDateTime registerTime;

    private String roles;

    @OneToMany(mappedBy="member")
    private Set<Orders> orders;

}
