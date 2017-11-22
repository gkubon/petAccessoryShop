package controllers;

import play.mvc.*;

import java.util.Set;

import models.*;

import views.html.*;
import views.html.items.categorie;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	public Result index() {
        return ok(index.render());
    }
	public Result products() {
        Set<Item> items = Item.allItems();
        return ok(products.render(items));
    }
    public Result categories(String blabla) {
        //Set<Item> items = Item.allItems();
        Set<Item> item = Item.findByCategorie(blabla);
    	if (item==null){
    		return notFound("categorie not found");
    	}
        return ok(categories.render(item));
    } 
    public Result welcome(String name, String lastname) {
        return ok( "HI , "  +name + "  " + lastname+" Welcome to PETSHOPAPP");
    }
    public Result basket() {
        return ok( "Basket is empty");
    }


}
