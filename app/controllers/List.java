package controllers;

import play.data.*;
import play.mvc.*;
import models.*;
import views.html.items.*;
import java.util.Set;
import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class List extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Inject
    FormFactory formFactory;

    public Result index() {
        Set<Item> items = Item.allItems();
        return ok(index.render(items));
    }
    public Result create()
    {
        Form<Item> itemForm=formFactory.form(Item.class);

        return ok(create.render(itemForm));
    }

    public Result show(Integer id) {
    	Item item = Item.findById(id);
    	if (item==null){
    		return notFound("item not found");
    	}
    	return ok(show.render(item));
    }
    /*    public Result welcome(String name, String lastname) {
        return ok( "HI , "  +name + " " + lastname+" Welcome to PETSHOPAPP");
    }*/
    public Result categorie(String categories) {
        //Set<Item> items = Item.allItems();
        Set<Item> item = Item.findByCategorie(categories);
    	if (item==null){
    		return notFound("categorie not found");
    	}
        return ok(categorie.render(item));

    }
    
    public Result edit(Integer id) {
        return TODO;
    }
    public Result update() {
        return TODO;
    }
    public Result save() {
        return TODO;
    }

    //for books details
    public Result destroy(Integer id) {
        return TODO;
    }
    public Result listCat(String category) {
        return ok( "category : "  +category + " not implemented ");
        //return TODO;
    }

    public Result list() {
        return ok( "List is empty");
    }


}
