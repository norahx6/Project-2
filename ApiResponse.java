package com.example.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ApiResponse {

    private String message;
    private int status;

}//end
