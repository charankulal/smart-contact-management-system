package com.charan.scms.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "Name is required")
    @Size(min = 3,message = "Name should contain more than 3 characters")
    private String name;
    @Email(message = "Invalid Email ID")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 4,message = "Minimum 6 characters are needed")
    private String password;
    @NotBlank(message = "About is required")
    private String about;
    @Size(min=8,max = 12,message = "Invalid Phone Number")
    private String phoneNumber;
}
