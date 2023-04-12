package com.example.shoppinglist;

import java.util.ArrayList;

public class ItemStorage {

    private ArrayList<Item> items = new ArrayList<>();

    private static ItemStorage storage = null;

    private ItemStorage(){
    }

    public static ItemStorage getInstance(){
        if(storage == null){
            storage = new ItemStorage();
        }
        return storage;
    }

    public void addItem(Item item){items.add(item);}

    public ArrayList<Item> getItems(){
        return items;
    }

    public Item getItemByIdNoRemove(int id){
        return items.get(id);
    }

    public void removeItem(String removable){
        int i=0;
        for(Item item : items){
            if(item.getItem().equals(removable)){
                break;
            }
        i++;
        }items.remove(i);
    }

}
