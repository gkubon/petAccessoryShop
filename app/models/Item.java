package models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import io.ebean.*;
import javax.persistence.*;

@Entity
public class Item extends Model{
	@Id
    public Long id;
    public String name;
    public Double price;
    public String categorie;
    public String description;
    public Integer quantity;
    public String color;
    public String picture;
    


    public static Finder<Long,Item> find = new Finder<>(Item.class);

}