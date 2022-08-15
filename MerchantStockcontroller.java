package com.example.project2.controller;


import com.example.project2.model.ApiResponse;
import com.example.project2.model.MerchantStock;
import com.example.project2.model.Product;
import com.example.project2.service.MerchantStockservice;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/va")
public class MerchantStockcontroller {

    private final MerchantStockservice merchantStockservice;
    public MerchantStockcontroller(MerchantStockservice merchantStockservice) {
        this.merchantStockservice = merchantStockservice;
    }

    // 1 getting
    @GetMapping("/merchantstock")
    public ResponseEntity getmerchantstock(){
        ArrayList<MerchantStock>merchantStocks= merchantStockservice.getmerchantstock();
        return ResponseEntity.status(200).body(merchantStocks);
    }

    // 2 Adding
    @PostMapping("/merchantstock")
    public ResponseEntity addmerchantstock(@RequestBody @Valid MerchantStock merchantStock, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        merchantStockservice.addmerchantstock(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("merchantstock added",200));
    }

    // 3 updeting
    @PutMapping("/merchantstock/{index}")
    public ResponseEntity updatemerchantstock(@RequestBody @Valid MerchantStock merchantStock, @PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        merchantStockservice.updatemerchantstock(index,merchantStock);
        return ResponseEntity.status(200).body("product updating");
    }

    // 4 deleting
    @DeleteMapping("/product/{index}")
    public ResponseEntity deletmrchantstock (@PathVariable int index){
        merchantStockservice.deletmrchantstock(index);
        return ResponseEntity.status(200).body("product deleting");

    }



}//end
