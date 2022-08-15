package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Merchant {
    //1
    @NotEmpty(message = "ID must not be empty")
    @Size(min= 3, max = 3 ,message = "ID have to be 3 character long")
    private String ID;
    //2
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3 ,max=3 ,message = " Name have to be 3 length long")
    private String name;

}//end

