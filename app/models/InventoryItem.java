package models;

import play.libs.Json;

import javax.persistence.Entity;

import com.fasterxml.jackson.databind.node.ObjectNode;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * The basic model for an item we're dealing with.
 */
@Entity
public class InventoryItem extends Model
{
    @Id
    public Long id;
    public String name;
    public Double price;
    public Integer quantity;
    public String imgPath;

    public static Map<String, String> asMap(InventoryItem item)
    {
        Map<String, String> itemAsMap = new HashMap<String, String>();
        itemAsMap.put("name", item.name);
        itemAsMap.put("price", "" +item.price);
        return itemAsMap;
    }
    public static ObjectNode asJsonNode(InventoryItem item)
    {
        ObjectNode node = Json.newObject();
        node.put("name", item.name);
        node.put("price", item.price);

        return node;
    }

    public static Finder<String,InventoryItem> find = new Finder<>(InventoryItem.class);
    
}
