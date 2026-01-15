import java.util.*;

public class SingleResponsibilityPrinciple {

    // Responsibility 1: Product data
    static class Product {
        String name;
        int price;

        Product(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    // Responsibility 2: Cart operations
    static class ShoppingCart {
        private List<Product> products = new ArrayList<>();

        public void addProduct(Product product) {
            products.add(product);
        }

        public List<Product> getProducts() {
            return products;
        }

        public int calculateTotal() {
            int total = 0;
            for (Product product : products) {
                total += product.price;
            }
            return total;
        }
    }

    // Responsibility 3: Invoice printing
    static class InvoicePrinter {
        public void printInvoice(ShoppingCart cart) {
            System.out.println("Invoice:");
            for (Product product : cart.getProducts()) {
                System.out.println(product.name + " - " + product.price);
            }
            System.out.println("Total: " + cart.calculateTotal());
        }
    }

    // Responsibility 4: Database saving
    static class CartRepository {
        public void saveToDatabase(ShoppingCart cart) {
            System.out.println("Cart saved to database successfully");
        }
    }

    // main method
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Book", 100));
        cart.addProduct(new Product("Pen", 200));

        InvoicePrinter printer = new InvoicePrinter();
        printer.printInvoice(cart);

        CartRepository repo = new CartRepository();
        repo.saveToDatabase(cart);
    }
}
