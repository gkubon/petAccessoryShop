package models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import io.ebean.*;
import javax.persistence.*;

@Entity
public class Farmer extends Model {
   @Id
   public Long id;
   public String email;
   public String password;
   public String name;
   public String wepay_access_token;
   public Long wepay_account_id;


   public static Finder<Long,Farmer> find = new Finder<>(Farmer.class);
   

}