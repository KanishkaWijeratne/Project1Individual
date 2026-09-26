import java.util.*;
import java.io.*;

public class Product implements Serializable {
  private static final long serialVersionUID = 1L;
  private String id;
  private String name;
  private int amountInStock;
  private double salePrice;

  public Product(String id, String name, int amountInStock, double salePrice) {
    this.id = id;
    this.name = name;
    this.amountInStock = amountInStock;
    this.salePrice = salePrice;
  }

  public String getName() {
    return name;
  }

  public int getAmountInStock() {
    return amountInStock;
  }

  public double getSalePrice() {
    return salePrice;
  }

  public String getId() {
    return id;
  }

  public boolean equals(String id) {
    return this.id.equals(id);
  }

  public String toString() {
    String string = "Product name " + name + " amount in stock " + amountInStock
        + " sale price " + salePrice + " id " + id;
    return string;
  }
}
