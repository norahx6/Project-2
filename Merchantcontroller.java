package com.example.project2.controller;

import com.example.project2.model.ApiResponse;
import com.example.project2.model.Merchant;
import com.example.project2.service.Merchantservice;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Merchantcontroller {

    private final Merchantservice merchantservice;
    public Merchantcontroller(Merchantservice merchantservice) {
        this.merchantservice = merchantservice;
    }

    // 1 getting
    @GetMapping("/merchant")
    public ResponseEntity getmerchant(){
        ArrayList<Merchant>merchants=merchantservice.getmerchant();
        return ResponseEntity.status(200).body(merchants);
    }

    // 2 adding
    @PostMapping("/merchant")
    public ResponseEntity addmerchant(@RequestBody @Valid Merchant merchant , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        merchantservice.addmerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("merchant added",200));
    }


    // 3 updating
    @PutMapping("/merchant/{index}")
    public ResponseEntity updatemerchant(@RequestBody @Valid Merchant merchant,@PathVariable int index , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        merchantservice.updatemerchant(index,merchant);
        return ResponseEntity.status(200).body(new ApiResponse("merchant update",200));

    }

    // 4 deleting
    @DeleteMapping("/merchant/{index}")
    public ResponseEntity deletmerchant(@PathVariable int index,Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        merchantservice.deletmerchant(index);
        return ResponseEntity.status(200).body(new ApiResponse("merchant deleted",200));

    }

}//end
