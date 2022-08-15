package com.example.project2.service;

import com.example.project2.model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Merchantservice {

    private ArrayList<Merchant>merchantlist=new ArrayList<>();

    // 1 gitting
    public ArrayList<Merchant> getmerchant() {
        return merchantlist;
    }

    // 2 adding
    public void addmerchant(Merchant merchant) {
        merchantlist.add(merchant);
    }

    // 3 updating
    public void updatemerchant(int index, Merchant merchant) {
        merchantlist.set(index,merchant);
    }

    // 4 deleting
    public void deletmerchant(int index) {

        merchantlist.remove(index);
    }




}//end
