package com.example.project2.service;


import com.example.project2.model.MerchantStock;
import com.example.project2.model.Product;
import com.example.project2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Userservice {

    private ArrayList<User> userlist = new ArrayList<>();
    private final MerchantStockservice merchantStockservice;
    private final Productservice productservice;

    public Userservice(MerchantStockservice merchantStockservice, Productservice productservice) {
        this.merchantStockservice = merchantStockservice;
        this.productservice = productservice;
    }


    // 1 getting
    public ArrayList<User> getuser() {
        return userlist;
    }

    // 2 adding
    public void adduser(User userr) {
        userlist.add(userr);
    }


    // 3 updating
    public void updateuser(int index, User userr) {
        userlist.set(index, userr);
    }

    public void deletuser(int index) {
        userlist.remove(index);
    }


    public Integer purchaseproudct(String userID, String productid, String merchantid) {
        User user = getuser(userID);
        MerchantStock merchantStock = merchantStockservice.getmerchantstock(merchantid);
        MerchantStock merchantStocks = merchantStockservice.getmerchantstocks(productid);
        Product product = productservice.getproduct(productid);

        if (user == null || merchantStock == null || merchantStocks == null) {
            return -1;
        }

        if (user.getBalance() < product.getPrice()) {
             return 0;
        }

        if (merchantStock.getStock() == 0) {
              return 1;
        }


            Integer oldstock = merchantStock.getStock();
            merchantStock.setStock(oldstock - 1);


            Integer oldBalance = user.getBalance();
            user.setBalance(oldBalance - product.getPrice());
            return 2;

        }


    private User getuser(String userID) {
        for (User user : userlist) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }


}// end
