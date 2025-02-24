import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    // Constructor
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters for name, category, and price
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }

    public static void main(String[] args) {
        // Create a list of Product objects
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1500.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("Headphones", "Electronics", 200.0),
                new Product("Shirt", "Clothing", 25.0),
                new Product("Jeans", "Clothing", 45.0),
                new Product("Socks", "Clothing", 10.0),
                new Product("Fridge", "Appliances", 900.0),
                new Product("Microwave", "Appliances", 300.0)
        );

        // 1. Grouping products by category
        System.out.println("Products grouped by category:");
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        productsByCategory.forEach((category, productList) -> {
            System.out.println("\n" + category + ":");
            productList.forEach(System.out::println);
        });

        // 2. Finding the most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        Map<String, Optional<Product>> mostExpensiveProductInCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));

        mostExpensiveProductInCategory.forEach((category, product) -> {
            product.ifPresent(p -> System.out.println(category + ": " + p));
        });

        // 3. Calculating the average price of all products
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
