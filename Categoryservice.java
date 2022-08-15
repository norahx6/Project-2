package com.example.project2.service;

import com.example.project2.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Categoryservice {


    private  ArrayList<Category>categorylist=new ArrayList<>();


    // 1 getting
    public ArrayList<Category> getcategory() {

        return categorylist;
    }

    // 2 adding
    public void addcategory(Category category){

        categorylist.add(category);
    }


    // 3 updating
    public void updatecategory(Category category, int index) {

        categorylist.set(index,category);
    }


    // 4 deleting
    public void deletecategory(int index) {

        categorylist.remove(index);
    }
}//end
