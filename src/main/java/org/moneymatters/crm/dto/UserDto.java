package org.moneymatters.crm.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String country;
}