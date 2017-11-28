package controllers;

import io.ebean.annotation.Cache;
import models.InventoryItem;
import models.Item;
import models.Cart;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.*;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import play.libs.Json;
import views.html.cartv;
import views.html.iindex;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: epanahi
 * Date: 12/2/12
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCart extends Controller
{
    public Result index() {
        List<Item> items = Item.find.all();
        List<Item> out = new Vector<Item>();
        Cart cart = Cart.find.byId((long)1);

        String[] ids = cart.items.split(",");

        for(Item item : items){
            for(String st : ids){
                if(item.id==Long.parseLong(st)){
                    out.add(item);
                }
            }
        }

        return ok(cartv.render(out));
    }

    public Result addToCart(Long id){
        String s = "UPDATE cart SET items= :items WHERE id = 1";
        SqlUpdate update = Ebean.createSqlUpdate(s);
        update.setParameter("items",Cart.find.byId((long) 1).items.concat(","+String.valueOf(id)));
        int count = Ebean.execute(update);
        List<Item> items = Item.find.all();
        List<Item> out = new Vector<Item>();
        Cart cart = Cart.find.byId((long)1);

        String[] ids = cart.items.split(",");

        for(Item item : items){
            for(String st : ids){
                if(item.id==Long.parseLong(st)){
                    out.add(item);
                }
            }
        }
        return ok(cartv.render(out));
    }

    public Result deleteFromCart(Long id){
        String s = "UPDATE cart SET items= :items WHERE id = 1";
        SqlUpdate update = Ebean.createSqlUpdate(s);
        update.setParameter("items",Cart.find.byId((long) 1).items.replaceFirst(String.valueOf(id),"0"));
        int count = Ebean.execute(update);
        List<Item> items = Item.find.all();
        List<Item> out = new Vector<Item>();
        Cart cart = Cart.find.byId((long)1);

        String[] ids = cart.items.split(",");

        for(Item item : items){
            for(String st : ids){
                if(item.id==Long.parseLong(st)){
                    out.add(item);
                }
            }
        }
        return ok(cartv.render(out));
    }

}
