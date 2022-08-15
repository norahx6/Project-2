package com.example.project2.controller;

import com.example.project2.model.ApiResponse;
import com.example.project2.model.Product;
import com.example.project2.model.User;
import com.example.project2.service.Productservice;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Productcontroller {

    //هنا عرفنا السرفر
    private final Productservice productservice;
    public Productcontroller(Productservice productservice) {

        this.productservice = productservice;
    }

    // 1- getting
    @GetMapping("/product")
    public ResponseEntity getproduct(){
        ArrayList<Product>product= productservice.getproduct();
        return ResponseEntity.status(200).body(product);
    }

    // 2 adding product
    @PostMapping("product")
    public ResponseEntity addproduct(@RequestBody @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        boolean isValidId = productservice.addproduct(product);
        if (isValidId) {
            return ResponseEntity.status(200).body(new ApiResponse("product added", 200));
        }
            return ResponseEntity.status(400).body(new ApiResponse("Invalid product Id",400));
    }

    // 3 updeting
    @PutMapping("/product/{index}")
    public ResponseEntity updteproduct(@RequestBody @Valid Product product,@PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        productservice.updateproduct(index,product);
        return ResponseEntity.status(200).body("product updating");
    }

    // 4 deleting
    @DeleteMapping("/product/{index}")
    public ResponseEntity deletproudct (@PathVariable int index){
        productservice.deleteproudct(index);
        return ResponseEntity.status(200).body("product deleting");

    }




}//end
