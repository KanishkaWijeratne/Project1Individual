import java.util.*;
import java.io.*;

public class WishListItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private Product product;
    private int quantity;

    public WishListItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Product " + product.getName() + " quantity " + quantity;
    }
}