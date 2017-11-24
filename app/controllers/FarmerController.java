package controllers;

import play.data.*;
import play.mvc.*;
import models.*;
import views.html.farmers.*;
import java.util.*;
import javax.inject.Inject;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class FarmerController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Inject
    FormFactory formFactory;

    public Result index() {
        List<Farmer> items = Farmer.find.all();

        return ok(index.render(items));
    }
    
    public Result create()
    {
        Form<Farmer> itemForm=formFactory.form(Farmer.class);
        if(itemForm.hasErrors()) {
        	return redirect(routes.FarmerController.index());
         } else {
             return ok(create.render(itemForm));
         }

    }

    public Result show(Long id) {
    	Farmer item = Farmer.find.byId(id);
    	if (item==null){
    		return notFound("item not found");
    	}
    	return ok(show.render(item));
    }
    /*    public Result welcome(String name, String lastname) {
        return ok( "HI , "  +name + " " + lastname+" Welcome to PETSHOPAPP");
    }*/
    public Result categorie(String categories) {
    /*	String sql =   "select name from product where price = 100";
    	Farmer.db().findList(SELECT * FROM EMPLOYEE_TBL;, transaction)db();
        List<Farmer> list = Farmer.find(Farmer.class)
     		   // fetch just these properties for the Order
     		  .select("categorie");
        //Set<Farmer> items = Farmer.allFarmers();
    	//Set<Farmer> item = Farmer.findByCategorie(categories);
    	/*Set<Farmer> item = Farmer.findByCategorie(categories);
    	if (item==null){
    		return notFound("categorie not found");
    	}
        return ok(categorie.render(item));
*/
        return TODO;
    }
    
    public Result edit(Long id) {
        return TODO;
    }
    public Result update() {
        return TODO;
    }
    public Result save() {
        Form<Farmer> itemForm=formFactory.form(Farmer.class).bindFromRequest();
        Farmer item= itemForm.get();
        item.save();
        return redirect(routes.FarmerController.index());
    }

    //for books details
    public Result destroy(Long id) {
    	Farmer item= Farmer.find.byId(id);
    	if (item==null) {
    		return notFound("item not found");
    	}
    	item.delete();
    	return redirect(routes.FarmerController.index());
    }
    public Result listCat(String category) {
        return ok( "category : "  +category + " not implemented ");
        //return TODO;
    }

    public Result list() {
        return ok( "List is empty");
    }


}
