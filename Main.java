import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Product> sales = new LinkedList<>();
        sales.add(new Product("Яблоко", 1.2, 10));
        sales.add(new Product("Банан", 0.8, 15));
        sales.add(new Product("Апельсин", 1.5, 8));

        System.out.println("Все проданные товары:");
        for (Product product : sales) {
            System.out.println(product);
        }

        double sum = sum(sales);
        System.out.println("Общая сумма продаж: " + sum);

        List<Product> mostPopularProducts = mostPopular(sales);
        if (!mostPopularProducts.isEmpty()) {
            System.out.print(" Самые популярные товары:");
            for (Product product : mostPopularProducts) {
                System.out.println(product.getName() + " (количество: " + product.getQuantity() + ")");
            }
        } else {
            System.out.println("Список товаров пуст.");
        }
    }

    public static double sum(LinkedList<Product> sales) {
        double sum = 0.0;
        for (Product product : sales) {
            sum += product.getPrice() * product.getQuantity();
        }
        return sum;
    }

    public static List<Product> mostPopular(LinkedList<Product> sales) {
        List<Product> mostPopularProducts = new LinkedList<>();
        if (sales.isEmpty()) {
            return mostPopularProducts;
        }

        int maxQuantity = 0;
        for (Product product : sales) {
            if (product.getQuantity() > maxQuantity) {
                maxQuantity = product.getQuantity();
            }
        }

        for (Product product : sales) {
            if (product.getQuantity() == maxQuantity) {
                mostPopularProducts.add(product);
            }
        }
        return mostPopularProducts;
    }
}