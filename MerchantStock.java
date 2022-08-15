package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class MerchantStock {
    //1
    @NotEmpty(message = "ID must not be empty")
    @Size(min= 3 , message = "ID have to be 3 character long")
    private String MerchantStockID;
    //2
    @NotEmpty(message = "productid must not be empty")
    @Size(min= 3 , message = "productid have to be 3 character long")
    private String  productid;
    //3
    @NotEmpty(message = "merchantid must not be empty")
    @Size(min= 3 , message = "merchantid have to be 3 length long")
    private String merchantid;
    //4
    @NotEmpty(message = "stock must not be empty")
    @Range(min = 10, message = "stock have to be more than 10 at start ")
    private int stock;

}//end
