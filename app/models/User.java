package models;

import java.util.HashSet;
import java.util.Set;


public class User {
    public Integer id;
    public String name;
    public String email;
    public String pass;

    public User(){
        name="unknown";
    }
    private static Set<User> users;
    static{
    	users = new HashSet<>();
    	users.add(new User(1,"Marcos","Marcos@marcos.pl","PASSMarcos"));
    	users.add(new User(2,"Anurag","Anurag@marcos.pl","PASSAnurag"));
    	users.add(new User(3,"Greg","Greg@marcos.pl","PASSGreg"));

    }
    public User(Integer id, String name, String email, String pass){
        this.id=id;
        this.name=name;
        this.email=email;
        this.pass=pass;
    }
}