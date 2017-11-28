package models;

import io.ebean.*;

import javax.inject.Inject;
import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart extends Model{

    @Id
    public Long id;
    public String items;


    public static Finder<Long,Cart> find = new Finder<>(Cart.class);

}