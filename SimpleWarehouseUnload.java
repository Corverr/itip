import java.util.*;

class Product {
    String name;
    int weight;

    Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + "(" + weight + "кг)";
    }
}

class Warehouse {
    List<Product> source = new ArrayList<>();
    List<Product> destination = new ArrayList<>();
    List<Product> truck = new ArrayList<>();
    int truckWeight = 0;
    final int MAX_WEIGHT = 150;

    Warehouse() {
        source.addAll(Arrays.asList(
                new Product("Холодильник", 60),
                new Product("Стиральная машина", 50),
                new Product("Телевизор", 20),
                new Product("Микроволновка", 15),
                new Product("Пылесос", 10)
        ));
    }

    synchronized Product take() {
        return source.isEmpty() ? null : source.remove(0);
    }

    synchronized boolean load(Product p) {
        if (truckWeight + p.weight > MAX_WEIGHT) {
            System.out.println("✗ Не могу загрузить " + p + " - перегруз!");
            unloadTruck(); // Разгружаем текущий груз
            return false;
        }

        truck.add(p);
        truckWeight += p.weight;
        System.out.println("✓ Загружен " + p + " (в грузовике: " + truckWeight + "кг)");

        if (truckWeight >= MAX_WEIGHT) {
            unloadTruck();
        }

        return true;
    }

    synchronized void unloadTruck() {
        if (truck.isEmpty()) return;

        System.out.println("\n🚛 Грузовик отправлен на разгрузку...");
        System.out.println("Вес: " + truckWeight + "кг, товаров: " + truck.size());

        // Имитация разгрузки
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        for (Product p : truck) {
            System.out.println("  ↓ Разгружаем " + p);
            destination.add(p);
        }

        System.out.println("✓ Разгрузка завершена!\n");

        truck.clear();
        truckWeight = 0;
    }

    synchronized boolean hasGoods() {
        return !source.isEmpty();
    }
}

class Worker extends Thread {
    Warehouse warehouse;

    Worker(String name, Warehouse w) {
        super(name);
        this.warehouse = w;
    }

    public void run() {
        while (warehouse.hasGoods()) {
            Product p = warehouse.take();
            if (p != null) {
                warehouse.load(p);

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {}
            }
        }

        // Отправляем последний грузовик
        warehouse.unloadTruck();
        System.out.println(getName() + " закончил");
    }
}

public class SimpleWarehouseUnload {
    public static void main(String[] args) throws InterruptedException {
        Warehouse w = new Warehouse();

        Worker w1 = new Worker("Грузчик-1", w);
        Worker w2 = new Worker("Грузчик-2", w);

        w1.start();
        w2.start();

        w1.join();
        w2.join();

        System.out.println("\n✅ Все товары перевезены!");
        System.out.println("На новом складе: " + w.destination.size() + " товаров");
    }
}