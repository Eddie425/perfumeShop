package com.shop.perfume.model;

import com.shop.perfume.common.UserRole;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    private String password;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String email;

    private String phone;

    private String postalCode;

    private String city;

    private String address;

    private String memberImage;

    private LocalDateTime registerTime;

    private String roles;

    @OneToMany(mappedBy="member")
    private Set<Orders> orders;

}
