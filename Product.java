package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Product {
    //1
    @NotEmpty(message = "ID must not be empty")
    @Size(min= 3 , message = "ID have to be 3 character long")
    private String productid;
    //2
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 3 , message = " Name have to be 3 length long")
    private String name;
    //3
    @NotNull(message = "Price must not be empty")
    @Positive
    private int price;
    //4
    @NotEmpty(message = "categoryID must not be empty")
    @Size(min= 3,message = "categoryID have to be 3 character long")
    private String  categoryID;


}//end
