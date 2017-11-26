package models;

import play.libs.Json;

import javax.persistence.Entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.util.*;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import io.ebean.Finder;
import io.ebean.Model;

/**
 * Created with IntelliJ IDEA.
 * User: epanahi
 * Date: 12/6/12
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cart
{
    /**
     * Process the customer's request; evaluate their needs against the inventory and return to them
     * a list of the optimal purchases.
     * @param items The items that the customer wants, as JsonNodes containing priority, quantity etc.
     * @param budget How much the customer wants to spend
     * @return An object node with fields 'spent', 'budget', 'totalcost', 'bought', and 'notbought' (and 'status' to find out how it went)
     */
    public static ObjectNode goShopping(ArrayNode items)
    {
        //Get the inventory
        Map<String, InventoryItem> map = (Map<String, InventoryItem>) new Finder(InventoryItem.class);
		Map<String, InventoryItem> inventory = map;

        //Create a list of 'useful' objects so that it's easy to sort
        List<ObjectNode> cart = new ArrayList<ObjectNode>();
        Iterator<JsonNode> iter = items.elements();
        while (iter.hasNext())
        {
            JsonNode node = iter.next();
            ObjectNode itemInfo = InventoryItem.asJsonNode(inventory.get(node.get("name").asText()));
            //itemInfo.set("buying", node.get("buying"));
            //itemInfo.set("priority", node.get("priority"));

            cart.add(itemInfo);
        };

        //ObjectNode result = Json.newObject();        
        ObjectNode result = Json.newObject();

        ArrayNode processed = JsonNodeFactory.instance.arrayNode();
        double totalcost = 0.0;
        double spent = 0.0;
        int currentIndex = 0;

        Iterator<ObjectNode> buyer = cart.iterator();

        while (buyer.hasNext())
        {

            ObjectNode node = buyer.next();

            double price = node.get("price").asDouble();
            int startingQuantity = node.get("buying").asInt();
            int numLeftToBuy = startingQuantity;
            int numBought = 0;
            totalcost += startingQuantity * price;

            while ( numLeftToBuy > 0)
            {
                //Object hasn't been added to the array
                node.put("bought", ++numBought);
                node.put("buying", --numLeftToBuy);
                spent += price;
            }
            if (numLeftToBuy > 0)
            {
                node.put("notbought", numLeftToBuy);
                node.remove("buying");
            };
            processed.add(node);
            buyer.remove();
            currentIndex++;

        }
        result.put("totalcost", totalcost);
        result.put("processed", processed);
        return result;
    }
}