package org.moneymatters.crm.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.moneymatters.crm.entity.User;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank(message = "Username Field is Blank.")  @Pattern(regexp = "^(?=.{8,20}$)(?![_.@])[a-zA-Z0-9._]+(?<![_.@])$", message = "Invalid username format.")
    private String username;
    @NotBlank(message = "First Name Field is Blank") @Size(min =3, max = 20, message = "First name size must be between 3 to 20 and only alphabets")
    private String firstName;
    @NotBlank(message = "Last Name Field is Blank") @Size(min = 3, max = 20, message = "Last Name size must be between 3 to 20 and only alphabets")
    private String lastName;
    @NotBlank(message = "Phone number field is Blank") @Pattern(regexp = "^[0-9]*$", message = "Invalid Phone Number format")
    private String phoneNumber;
    @NotBlank(message = "Email Field is Blank") @Email(message = "Invalid Email Format")
    private String email;
    @NotBlank(message = "Password Field is Blank") @Size(min = 8, max = 16) @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&_])[A-Za-z\\d@$!%*?&]{8,16}$", message = "Invalid Password Format.")
    private String password;
    @NotBlank(message = "Country Field is Blank") @Pattern(regexp = "^[a-zA-Z]{2,}", message = "Invalid Country")
    private String country;

}