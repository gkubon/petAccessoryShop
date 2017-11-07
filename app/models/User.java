package models;

import java.util.HashSet;
import java.util.Set;


public class User {
    public Long id;
    public String name;
    public String email;
    public String pass;

    public User(){
        name="unknown";
    }
    public User(Integer id, String name, String email, String pass){
        this.id=id;
        this.name=name;
        this.email=email;
        this.pass=pass;
    }
}