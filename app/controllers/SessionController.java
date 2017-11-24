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
public class SessionController extends Controller {
	

	
	
	public Result login() {
	    
	    Form<Login> itemForm=formFactory.form(Login.class);

        return ok(login.render(itemForm));
	   }


    @Inject
    FormFactory formFactory;
	   public Result authenticate() {
		   
        Form<Farmer> itemForm=formFactory.form(Farmer.class).bindFromRequest();
        Farmer item= itemForm.get();
        if(itemForm.hasErrors()) {
	         return redirect(routes.SessionController.login());
	      } else {
	         session("connected", itemForm.get().email);
	         return redirect(routes.FarmerController.index());
	      }
	   }
	   
	   public Result logout() {
	      session().clear();
	      return redirect(routes.FarmerController.index());
	   }
	   
	   public static boolean isSessionOwner(Farmer farmer) {
	      if (farmer.email.equals(session("connected"))) return true;
	      else return false;
	   }
	}