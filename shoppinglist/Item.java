package com.example.shoppinglist;

import java.io.Serializable;

public class Item implements Serializable {

    protected String item;

    public Item(String item){
        this.item = item;
    }

    public void setItem(String item){this.item = item;}

    public String getItem(){return item;}
}
