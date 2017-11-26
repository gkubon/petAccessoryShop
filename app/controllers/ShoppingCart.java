package controllers;

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

import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: epanahi
 * Date: 12/2/12
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCart extends Controller
{
    /**
     * Extract the information from the request and pass it to the Shopper object
     * @return
     */
    @BodyParser.Of(BodyParser.Json.class)
    public Result goShopping() {
        JsonNode json = request().body().asJson();
        ArrayNode items = (ArrayNode) json.get("items");

        ObjectNode result = Cart.goShopping(items);

        String returnCode = result.remove("status").asText();
        if(returnCode.equals("OK")){
            return ok(result);
        } else {
            return badRequest(result);
        }
    }    
    public Result save() {        
    	
    	return TODO;
    }
}
