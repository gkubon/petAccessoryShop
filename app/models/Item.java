package models;

import java.util.HashSet;
import java.util.Set;


public class Item {
    public Integer id;
    public String name;
    public Integer price;
    public String categorie;

    public Item(){

    }
    public Item(Integer id, String name, Integer price, String categorie){
        this.id=id;
        this.name=name;
        this.price=price;
        this.categorie=categorie;
    }
    private static Set<Item> items;
    static{
        items = new HashSet<>();
        items.add(new Item(1,"me da igual", 20,"dog"));
        items.add(new Item(2,"tambien me da igual", 220,"cat"));

    }
    public static Set<Item> allItems(){
        return items;
    }
    public static Item findById(Integer id){
        /*for(Item item: items){
            if(id.equals(items.id)){
                return item;
            }
        }*/
        return null;
    }
    public static void add(Item item){
        items.add(item);
    }
    public static boolean remove(Item item){
        return items.remove(item);
    }

}