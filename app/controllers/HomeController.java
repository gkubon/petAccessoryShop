package controllers;

import play.data.FormFactory;
import play.mvc.*;

import java.util.*;

import models.*;

import play.api.db.*;

import views.html.*;
import play.data.Form;
import play.data.Form.*;

import models.InventoryItem;
import io.ebean.*;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import views.html.*;

import javax.inject.Inject;

import static play.libs.Json.toJson;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.List;


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
    @Inject
    FormFactory formFactory;

	public Result index() {
        List<Item> items = Item.find.all();
        InventoryItem inv = new InventoryItem();
        Form<InventoryItem> searchForm = formFactory.form(InventoryItem.class).fill(inv);
        return ok(iindex.render(items,(long)0,"zuza",searchForm));
    }

    public Result indexLogged(Long ID){
	    List<Item> items = Item.find.all();
        InventoryItem inv = new InventoryItem();
        Form<InventoryItem> searchForm = formFactory.form(InventoryItem.class).fill(inv);
	    return ok(iindex.render(items,ID,Farmer.find.byId(ID).email,searchForm));
    }

    
    public Result cat(String cat,Long ID){
	    List<Item> items = Item.find.all();
	    List<Item> out = new Vector<Item>();

	    for(Item it : items){
	        if(it.categorie.equalsIgnoreCase(cat)){
	            out.add(it);
            }
        }
        String abc = "zuz";
        if(ID!=0){
            abc = Farmer.find.byId(ID).email;
        }


        InventoryItem inv = new InventoryItem();
        Form<InventoryItem> searchForm = formFactory.form(InventoryItem.class).fill(inv);
        return ok(iindex.render(out,ID,abc,searchForm));
    }

    public Result login(){
        Farmer farmer = new Farmer();
        Form<Farmer> loginForm = formFactory.form(Farmer.class).fill(farmer);
        return ok(loginn.render(loginForm));
    }

    public Result register(){
        Farmer farmer = new Farmer();
        Form<Farmer> registerForm = formFactory.form(Farmer.class).fill(farmer);
        return ok(register.render(registerForm));
    }

    public Result loginPost(){
        Form<Farmer> userForm = formFactory.form(Farmer.class).bindFromRequest();
        List<Farmer> farmers = Farmer.find.all();
        Long id = Long.valueOf(0);
        for(Farmer f : farmers){
            if(f.email.equals(userForm.get().email)&&f.password.equals(userForm.get().password)){
                id = f.id;
            }
        }
        List<Item> items = Item.find.all();
        InventoryItem inv = new InventoryItem();
        Form<InventoryItem> searchForm = formFactory.form(InventoryItem.class).fill(inv);
        return ok(iindex.render(items,id,userForm.get().email,searchForm));
    }

    public Result searchPost(Long ID) {
        Form<InventoryItem> searchForm = formFactory.form(InventoryItem.class).bindFromRequest();
        List<Item> out = new Vector<>();
        List<Item> all = Item.find.all();
        for(Item it : all){
            if(it.name.toLowerCase().contains(searchForm.get().name.toLowerCase())||it.categorie.toLowerCase().contains(searchForm.get().name.toLowerCase())||it.description.toLowerCase().contains(searchForm.get().name.toLowerCase())){
                out.add(it);
            }
        }
        if(ID==0){
            return ok(iindex.render(out,ID,"zuz",searchForm));
        }else{
            return ok(iindex.render(out,ID,Farmer.find.byId(ID).email,searchForm));
        }

    }

    public Result registerPost(){
        Form<Farmer> userForm = formFactory.form(Farmer.class).bindFromRequest();
        List<Farmer> farmers = Farmer.find.all();
        Long id = Long.valueOf(0);
        for(Farmer f: farmers){
            if(f.email.equals(userForm.get().email)){
                Farmer farmer = new Farmer();
                Form<Farmer> loginForm = formFactory.form(Farmer.class).fill(farmer);
                return ok(loginn.render(loginForm));
            }
            id = f.id;
        }



        id=id+1;
        String s = "INSERT INTO farmer VALUES (:id,:mail,:pass,:mail,null,null)";
        SqlUpdate update = Ebean.createSqlUpdate(s);
        update.setParameter("id", id);
        update.setParameter("mail",userForm.get().email);
        update.setParameter("pass",userForm.get().password);
        int count = Ebean.execute(update);

        Farmer farmer = new Farmer();
        Form<Farmer> loginForm = formFactory.form(Farmer.class).fill(farmer);
        return ok(loginn.render(loginForm));

    }

	public Result products() {
        List<Item> items = Item.find.all();
        return ok(products.render(items));
    }
	
	public  Result addItem() {
        return TODO;
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
