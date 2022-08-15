package com.example.project2.service;

import com.example.project2.model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockservice {

    private ArrayList<MerchantStock>merchantStockslist= new ArrayList<>();
    private Merchantservice merchantservice;

    // 1 getting
    public ArrayList<MerchantStock> getmerchantstock() {

        return merchantStockslist;
    }

    // 2 adding
    public boolean addmerchantstock(MerchantStock merchantStock) {

        return merchantStockslist.add(merchantStock);

    }

    // 3 updating
    public void updatemerchantstock(int index, MerchantStock merchantStock) {

        merchantStockslist.set(index,merchantStock);
    }


    // 3 deleting
    public void deletmrchantstock(int index) {

        merchantStockslist.remove(index);
    }


    public MerchantStock getmerchantstock(String merchantid ) {
        for (MerchantStock merchantStock: merchantStockslist) {
            if (merchantStock.getMerchantid().equals(merchantid)){
                return merchantStock;
            }
        }
        return null;
    }

    public MerchantStock getmerchantstocks(String productid) {
        for (MerchantStock merchantStock: merchantStockslist) {
            if (merchantStock.getProductid().equals(productid)){
                return merchantStock;
            }
        }
        return null;
    }


}// end
