import java.util.*;
import java.io.*;


public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String address;
    private List<WishListItem> wishlist = new LinkedList<WishListItem>();

    public Client(String id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getId(){
        return id;
    }


    public List<WishListItem> getWishList(){
        return wishlist;
    }

    public WishListItem addToWishList(Product product, int quantity){
        for( WishListItem item: wishlist){
            if (item.getProduct().getId().equals(product.getId())){
                item.setQuantity(quantity);
                return item;
            }
        }
        WishListItem newItem = new WishListItem(product, quantity);
        wishlist.add(newItem);
        return newItem;
    }

    public boolean equals(String id){
        return this.id.equals(id);
    }

    public String toString(){
        String string = "Client name " + name + " address " + address + " id " + id;
        return string;
    }
}