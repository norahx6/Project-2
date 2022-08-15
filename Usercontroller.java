package com.example.project2.controller;


import com.example.project2.model.ApiResponse;
import com.example.project2.model.Product;
import com.example.project2.model.User;
import com.example.project2.service.Userservice;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Usercontroller {
    private final Userservice userservice;

    public Usercontroller(Userservice userservice) {
        this.userservice = userservice;
    }

    // 1 getting
    @GetMapping("/user")
    public ResponseEntity getuser(){
        ArrayList<User>users=userservice.getuser();
        return ResponseEntity.status(200).body(users);
    }

    // 2 adding
    @PostMapping("/user")
    public ResponseEntity adduser(@RequestBody @Valid User userr , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        userservice.adduser(userr);
        return ResponseEntity.status(200).body(new ApiResponse("user added",200));
    }

    // 3 ubdating
    @PutMapping("/user/{index}")
    public ResponseEntity updteuser(@RequestBody @Valid User userr, @PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        userservice.updateuser(index,userr);
        return ResponseEntity.status(200).body("user updating");
    }

    // 4 deleting
    @DeleteMapping("/user/{index}")
    public ResponseEntity deletuser (@PathVariable int index){
        userservice.deletuser(index);
        return ResponseEntity.status(200).body("user deleting");

    }


    // purchesproduct
    @PostMapping("/purchase")
    public  ResponseEntity<String> purchaseproudct(@RequestParam String userID, @RequestParam String productid , @RequestParam String merchantid){
        Integer userCase=userservice.purchaseproudct(userID,productid,merchantid);
        switch (userCase){
            case -1:
                return ResponseEntity.status(400).body("User id or product id or merchant is wrong");
            case 0:
                return ResponseEntity.status(400).body("You don't have enough money for the proudct");
            case 1:
                return ResponseEntity.status(400).body("There is no product available to buy in the stock");
            case 2:
                return ResponseEntity.status(200).body("product purchased !");
            default:
                return ResponseEntity.status(400).body("Server error !");
        }
    }




}// end
