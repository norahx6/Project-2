package com.example.project2.service;

import com.example.project2.model.Category;
import com.example.project2.model.Product;
import com.example.project2.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Productservice {

    private ArrayList<Product>productlist=new ArrayList<>();
    private Categoryservice categoryservice;

    public Productservice(Categoryservice categoryservice) {
        this.categoryservice = categoryservice;
    }

    // 1 getting
    public ArrayList<Product> getproduct() {
        
        return productlist;
    }

    // 2 adding
    public boolean addproduct(Product product) {
        ArrayList<Category>categorys=categoryservice.getcategory();

        for (int i = 0; i < categorys.size(); i++) {
            if(categorys.get(i).getID()==product.getCategoryID()){
                productlist.add(product);
                return true;
            }
        }
        return false;
    }

    // 3 updating
    public void updateproduct(int index, Product product) {

        productlist.set(index,product);
    }


    // 4 deleting
    public void deleteproudct(int index) {

        productlist.remove(index);
    }

    public Product getproduct(String productid) {
            for (Product product : productlist) {
                if (product.getProductid().equals(productid)) {
                    return product;
                }
            }
            return null;
        }



}//end
