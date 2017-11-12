package models;

import java.util.HashSet;
import java.util.Set;


public class Item {
    public Integer id;
    public String name;
    public Integer price;
    public String categorie;
    public String description;
    public String color;
    public String picture;
    



    public Item(){

    }
    public Item(Integer id, String name, Integer price, String categorie,String description){
        this.id=id;
        this.name=name;
        this.price=price;
        this.categorie=categorie;
        this.description=description;
        //this.color=color;
    }    
    public Item(Integer id, String name, Integer price, String categorie,String description,String picture){
        this.id=id;
        this.name=name;
        this.price=price;
        this.categorie=categorie;
        this.description=description;
        this.picture=picture;
        //this.color=color;
    }    
    public Item(Integer id, String name, String categorie,String description,String picture){
        this.id=id;
        this.name=name;
        this.price=9999999;
        this.categorie=categorie;
        this.description=description;
        this.picture=picture;
        //this.color=color;
    }
    private static Set<Item> items;
    static{
        items = new HashSet<>();
        items.add(new Item(1,"Cat bell", 204,"cat","ring ring","PATH"));
        items.add(new Item(2,"Cat house", 2320,"cat","qwert"));
        items.add(new Item(3,"Cat cover", 24320,"cat","qwert"));
        items.add(new Item(4,"tiger love", 28670,"tiger","<3<3<3<3<3<3<3<3"));
        items.add(new Item(5,"Cat carrier", 28670,"cat","etmate(R) Sky Kennel(R) Dog Crate You only want the best for your dog, especially when traveling. The Sky Kennel(R) Dog Crate by PetMate(R) is preferred by airlines and is approved by the ATA (Airline Transportation Association). With heavy-dut"));
        items.add(new Item(6,"dog house", 228760,"dog","sdsadsadsada"));
        items.add(new Item(7,"dog food", 87,"dog","zcxxzczcx"));
        items.add(new Item(8,"dog cover", 22768732,"dog","qwqweqweqewert"));
        items.add(new Item(9,"dog crate", 287223,"dog","gfdgfd"));
        items.add(new Item(10,"dog house", 286865322,"dog","Dog House Built to endure years of use, the Pet Zone Tuff-n-Rugged doghouse has earned the Consumer Digest Best Buy Award, and is an excellent choice for dog owners who need a rugged structure that offers comfort even in extreme w"));

    }
    public static Set<Item> allItems(){
        return items;
    }
    public static Item findById(Integer id){
        for(Item item: items){
            if(id.equals(item.id)){
                return item;
            }
        }
        return null;
    }
	public static Set<Item> findByCategorie(String categorie) {

        HashSet<Item> list_of_item = new HashSet<>();
        for(Item item: items){
            if(categorie.equals(item.categorie)){
            	list_of_item.add(item);
            }
        }
		return list_of_item;
	}
    public static void add(Item item){
        items.add(item);
    }
    public static boolean remove(Item item){
        return items.remove(item);
    }
}