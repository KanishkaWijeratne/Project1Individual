import java.util.*;

public class TestDriver {

    public static void main(String[] args) {
        System.out.println("=== Testing ClientList singleton ===");
        ClientList list1 = ClientList.instance();
        ClientList list2 = ClientList.instance();
        check("Singleton returns same instance", list1 == list2);

        System.out.println("\n=== Testing insertClient() and unique ID generation ===");
        Client c1 = list1.insertClient("Alice Smith", "123 Main St");
        Client c2 = list1.insertClient("Bob Jones", "456 Oak Ave");
        System.out.println("Created: " + c1);
        System.out.println("Created: " + c2);
        check("Client 1 has non-null ID", c1.getId() != null);
        check("Client 2 has different ID than Client 1",
                !c1.getId().equals(c2.getId()));
        check("Client 1 name stored correctly", c1.getName().equals("Alice Smith"));
        check("Client 1 address stored correctly", c1.getAddress().equals("123 Main St"));

        System.out.println("\n=== Testing search() ===");
        Client found = list1.search(c1.getId());
        check("search() finds existing client by ID", found == c1);

        Client notFound = list1.search("C999");
        check("search() returns null for unknown ID", notFound == null);

        System.out.println("\n=== Testing getClients() iterator ===");
        Iterator<Client> it = list1.getClients();
        int count = 0;
        while (it.hasNext()) {
            System.out.println("  " + it.next());
            count++;
        }
        check("getClients() returns all inserted clients", count == 2);

        System.out.println("\n=== Testing Client.addToWishList() - new item ===");
        Product p1 = new Product("P1", "Widget", 50, 9.99);
        WishListItem item1 = c1.addToWishList(p1, 3);
        check("addToWishList() returns a WishListItem", item1 != null);
        check("New item has correct product", item1.getProduct() == p1);
        check("New item has correct quantity", item1.getQuantity() == 3);
        check("Client's wishlist now has 1 item", c1.getWishList().size() == 1);

        System.out.println("\n=== Testing Client.addToWishList() - existing item (overwrite) ===");
        WishListItem item2 = c1.addToWishList(p1, 7);
        check("Adding same product again overwrites quantity", item2.getQuantity() == 7);
        check("Wishlist still has only 1 item (no duplicate)",
                c1.getWishList().size() == 1);
        check("Returned item is the same object as before", item2 == item1);

        System.out.println("\n=== Testing Client.addToWishList() - second distinct product ===");
        Product p2 = new Product("P2", "Gadget", 20, 19.99);
        c1.addToWishList(p2, 2);
        check("Wishlist now has 2 distinct items", c1.getWishList().size() == 2);

        System.out.println("\n=== Displaying final wishlist for " + c1.getName() + " ===");
        for (WishListItem item : c1.getWishList()) {
            System.out.println("  " + item.getProduct().getName()
                    + " - quantity: " + item.getQuantity());
        }
        System.out.println("\n=== Testing ProductList ===");

        ProductList productList = ProductList.instance();
        ProductList productList2 = ProductList.instance();

        check("ProductList returns same singleton instance",
                productList == productList2);

        Product p3 = new Product("P3", "Book", 10, 14.99);
        productList.insertProduct(p3);

        check("Product inserted successfully",
                productList.search("P3") == p3);

        check("Unknown product returns null",
                productList.search("P999") == null);

        Iterator<Product> productIterator = productList.getProducts();
        int productCount = 0;

        while (productIterator.hasNext()) {
            System.out.println("  " + productIterator.next());
            productCount++;
        }

        check("getProducts() returns inserted product",
                productCount == 1);

        System.out.println("\n=== All tests complete ===");
    }

    private static void check(String description, boolean condition) {
        System.out.println((condition ? "PASS: " : "FAIL: ") + description);
    }
}