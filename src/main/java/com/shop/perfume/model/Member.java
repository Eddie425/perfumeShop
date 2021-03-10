package com.shop.perfume.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "member")
public class Member {

    @Id
    private String memberID;

    private String password;

    private String firstName;

    private String lastName;

    private LocalDateTime dateOfBirth;

    private String email;

    private String phone;

    private String postalCode;

    private String city;

    private String address;

    private String memberImage;

    private LocalDateTime registerTime;

    private Integer userType;

}
