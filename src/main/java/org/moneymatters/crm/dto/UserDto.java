package org.moneymatters.crm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    @NotEmpty
    @Size(min = 2, message = "First Name should have at least 2 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 2, message = "Last name should have at least 2 characters")
    private String lastName;
    @NotEmpty
    @Email(message = "invalid Email Id")
    private String email;
    @NotNull
    @Size(min = 8, max = 16, message = "password should have 8 to 16 characters.")
    private String password;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String country;
}
