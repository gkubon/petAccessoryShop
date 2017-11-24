package controllers;

import play.mvc.*;

import java.util.List;
import java.util.Set;

import models.*;

import views.html.*;
//import views.html.items.categorie;

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
        List<Item> items = Item.find.all();
        return ok(products.render(items));
    }
    public Result categorie(String categories) {
        //Set<Item> items = Item.allItems();
    	//Set<Item> item = Item.findByCategorie(categories);
    	/*Set<Item> item = Item.findByCategorie(categories);
    	if (item==null){
    		return notFound("categorie not found");
    	}
        return ok(categorie.render(item));
*/
    	//return ok( "TODO");
        return TODO;
    }
    public Result welcome(String name, String lastname) {
        return ok( "HI , "  +name + "  " + lastname+" Welcome to PETSHOPAPP");
    }
    public Result basket() {
        return ok( "Basket is empty");
    }


}
