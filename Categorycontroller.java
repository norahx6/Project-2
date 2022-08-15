package com.example.project2.controller;

import com.example.project2.model.ApiResponse;
import com.example.project2.model.Category;
import com.example.project2.service.Categoryservice;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
public class Categorycontroller {

    private final Categoryservice categoryservice;
    public Categorycontroller(Categoryservice categoryservice) {

        this.categoryservice = categoryservice;
    }


    // 1 getting
    @GetMapping("/category")
    public ResponseEntity getcategory(){
        ArrayList<Category>categorys= categoryservice.getcategory();
        return ResponseEntity.status(200).body(categorys);
    }

    // 2 Adding
    @PostMapping("/category")
    public ResponseEntity addcategory (@RequestBody @Valid Category category, Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        categoryservice.addcategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("category added",200));
    }

    // 3 Updating
    @PutMapping("/category/{index}")
    public ResponseEntity updatecategory(@RequestBody @Valid Category category ,@PathVariable int index,Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse( message , 400));
        }
        categoryservice.updatecategory(category,index);
        return ResponseEntity.status(200).body(new ApiResponse("category ubdating",200));
    }

    //4 Deleiting
    @DeleteMapping("/category/{index}")
    public ResponseEntity deletecategory(@PathVariable int index,Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse( message , 400));
        }
        categoryservice.deletecategory(index);
        return ResponseEntity.status(200).body(new ApiResponse("category deleing",200));
    }






}//end
