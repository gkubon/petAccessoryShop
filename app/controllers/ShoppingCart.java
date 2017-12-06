package controllers;


import akka.Done;
import models.Farmer;
import models.InventoryItem;
import models.Item;
import models.Cart;

import io.ebean.*;

import play.cache.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.cartv;
import views.html.iindex;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import javax.inject.Inject;



public class ShoppingCart extends Controller
{

    @Inject
    FormFactory formFactory;

    public Result index(Long id) {

        if(Cart.find.byId(id)==null) {
            String s = "INSERT INTO cart VALUES (:id,'0')";
            SqlUpdate update = Ebean.createSqlUpdate(s);
            update.setParameter("id", id);
            int count = Ebean.execute(update);
        }

        List<Cart> carts = Cart.find.all();
        String items = "-1";
        for(Cart cart : carts){
            if(cart.id==id){
                items = cart.items;
            }
        }

        Item.find.all();
        List<Item> out = new Vector<Item>();

        String[] ids = items.split(",");

        for(Item item : Item.find.all()){
            for(String st : ids){
                if(item.id==Long.parseLong(st)){
                    out.add(item);
                }
            }
        }
        Double price = Double.valueOf(0);
        for(Item it: out){
            price=price+it.price;
        }

        InventoryItem inv = new InventoryItem();
        Form<InventoryItem> searchForm = formFactory.form(InventoryItem.class).fill(inv);

        return ok(cartv.render(out,id,Farmer.find.byId(id).email,price,searchForm));

       // Long abc = (long)Cart.find.all().size();
       // Cart cart = Cart.find.byId(abc);
       // String s = "INSERT INTO cart VALUES (:id,'0')";
       // SqlUpdate update = Ebean.createSqlUpdate(s);
       // update.setParameter("id",id);
       // int count = Ebean.execute(update);
    }

    public Result addToCart(Long id,Long item){

        if(Cart.find.byId(id)==null) {
            String s = "INSERT INTO cart VALUES (:id,'0')";
            SqlUpdate update = Ebean.createSqlUpdate(s);
            update.setParameter("id", id);
            int count = Ebean.execute(update);
        }

        String s = "UPDATE cart SET items= :items WHERE id = :id";
        SqlUpdate update = Ebean.createSqlUpdate(s);
        update.setParameter("items",Cart.find.byId(id).items.concat(","+String.valueOf(item)));
        update.setParameter("id",id);
        int count = Ebean.execute(update);
        List<Item> items = Item.find.all();
        List<Item> out = new Vector<Item>();
        Cart cart = Cart.find.byId(id);

        String[] ids = cart.items.split(",");

        for(Item itm : items){
            for(String st : ids){
                if(itm.id==Long.parseLong(st)){
                    out.add(itm);
                }
            }
        }
        InventoryItem inv = new InventoryItem();
        Form<InventoryItem> searchForm = formFactory.form(InventoryItem.class).fill(inv);
        //return ok(cartv.render(out,id,Farmer.find.byId(id).email));
        return ok(iindex.render(Item.find.all(),id,Farmer.find.byId(id).email,searchForm));
    }

    public Result deleteFromCart(Long id, Long item){
        String s = "UPDATE cart SET items= :items WHERE id = :id";
        SqlUpdate update = Ebean.createSqlUpdate(s);
        update.setParameter("items",Cart.find.byId(id).items.replaceFirst(String.valueOf(item),"0"));
        update.setParameter("id",id);
        int count = Ebean.execute(update);
        List<Item> items = Item.find.all();
        List<Item> out = new Vector<Item>();
        Cart cart = Cart.find.byId(id);

        String[] ids = cart.items.split(",");

        for(Item itm : items){
            for(String st : ids){
                if(itm.id==Long.parseLong(st)){
                    out.add(itm);
                }
            }
        }
        Double price = Double.valueOf(0);
        for(Item it: out){
            price=price+it.price;
        }
        InventoryItem inv = new InventoryItem();
        Form<InventoryItem> searchForm = formFactory.form(InventoryItem.class).fill(inv);
        return ok(cartv.render(out,id, Farmer.find.byId(id).email,price,searchForm));
    }

    public Result deleteAllFromCart(Long id){
        String s = "UPDATE cart SET items= :items WHERE id = :id";
        SqlUpdate update = Ebean.createSqlUpdate(s);
        update.setParameter("items","0");
        update.setParameter("id",id);
        int count = Ebean.execute(update);
        List<Item> items = Item.find.all();
        List<Item> out = new Vector<Item>();
        Cart cart = Cart.find.byId(id);

        String[] ids = cart.items.split(",");

        for(Item itm : items){
            for(String st : ids){
                if(itm.id==Long.parseLong(st)){
                    out.add(itm);
                }
            }
        }
        Double price = Double.valueOf(0);
        for(Item it: out){
            price=price+it.price;
        }
        InventoryItem inv = new InventoryItem();
        Form<InventoryItem> searchForm = formFactory.form(InventoryItem.class).fill(inv);
        return ok(cartv.render(out,id, Farmer.find.byId(id).email,price,searchForm));
    }
}
