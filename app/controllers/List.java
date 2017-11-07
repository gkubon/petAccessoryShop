package controllers;

import play.mvc.*;
import models.*;
import views.html.items.*;
import java.util.Set;

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
    public Result index() {
        Set<Item> items = Item.allItems();
        return ok(index.render(items));
    }
    public Result create() {
        return TODO;
    }
    public Result show(Integer id) {
        return TODO;
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
        return ok( "category , "  category );
    }

    public Result list() {
        return ok( "List is empty");
    }


}
