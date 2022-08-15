package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class User {
    //1
    @NotEmpty(message = "ID must not be empty")
    @Size(min= 3 , message = "ID have to be 3 character long")
    private String userID;
    //2
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3 , message = " Name have to be 3 length long")
    private String username;
    //3
    @NotEmpty(message = "Password must not be empty")
    @Size(min = 6 , message = " Password have to be 6 length long")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",message = "Password must have characters and digits")
    private String password;
    //4
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid ")
    private String email;
    //5
    @NotEmpty(message = "Role must not be empty")
    @Pattern(regexp = "(Admin|Customer)",message = "have to be in ( “Admin”,”Customer”)")
    private String role;
    //6
    @NotEmpty(message = "Price must not be empty")
    @Pattern(regexp = "^[1-9]+[0-9]*$",message = "must be positive number ")
    private int balance;


}//end
