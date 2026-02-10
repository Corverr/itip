import java.util.Scanner;

public class VehicleDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ДЕМОНСТРАЦИЯ ИЕРАРХИИ КЛАССОВ ТРАНСПОРТНЫХ СРЕДСТВ ===\n");

        // Демонстрация принципов ООП

        // 1. Наследование - создание объектов разных классов
        System.out.println("1. СОЗДАНИЕ ОБЪЕКТОВ:");

        // Создание легкового автомобиля
        Car car1 = new Car("Toyota", "Camry", 2023, 5, "Бензин", true);
        System.out.println("Создан легковой автомобиль:");
        car1.displayInfo();

        // Создание грузового автомобиля
        Truck truck1 = new Truck("Volvo", "FH16", 2022, 25.5, 3, true);
        System.out.println("Создан грузовой автомобиль:");
        truck1.displayInfo();

        // Создание мотоцикла
        Motorcycle motorcycle1 = new Motorcycle("Yamaha", "YZF-R6", 2023, "Спортивный", false, 600);
        System.out.println("Создан мотоцикл:");
        motorcycle1.displayInfo();

        // 2. Инкапсуляция - использование геттеров и сеттеров
        System.out.println("2. ДЕМОНСТРАЦИЯ ИНКАПСУЛЯЦИИ:");
        System.out.println("Марка автомобиля: " + car1.getBrand());
        car1.setBrand("Honda");
        System.out.println("Измененная марка автомобиля: " + car1.getBrand());

        // 3. Полиморфизм - использование объектов через ссылку на базовый класс
        System.out.println("\n3. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА:");

        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = car1;
        vehicles[1] = truck1;
        vehicles[2] = motorcycle1;

        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();  // Полиморфный вызов
            vehicle.stopEngine();   // Полиморфный вызов
            System.out.println();
        }

        // 4. Абстракция - использование абстрактных методов
        System.out.println("4. ДЕМОНСТРАЦИЯ АБСТРАКЦИИ:");
        // Vehicle abstractVehicle = new Vehicle(); // Ошибка! Нельзя создать экземпляр абстрактного класса

        // 5. Демонстрация работы счетчика объектов
        System.out.println("5. СЧЕТЧИК СОЗДАННЫХ ОБЪЕКТОВ:");
        System.out.println("Всего создано транспортных средств: " + Vehicle.getVehicleCount());

        // Создание дополнительных объектов для демонстрации счетчика
        Car car2 = new Car();
        Truck truck2 = new Truck();
        System.out.println("После создания дополнительных объектов: " + Vehicle.getVehicleCount());

        // 6. Ввод данных от пользователя
        System.out.println("\n6. ВВОД ДАННЫХ ОТ ПОЛЬЗОВАТЕЛЯ:");

        System.out.println("Введите данные для нового автомобиля:");
        System.out.print("Марка: ");
        String brand = scanner.nextLine();
        System.out.print("Модель: ");
        String model = scanner.nextLine();
        System.out.print("Год выпуска: ");
        int year = scanner.nextInt();
        System.out.print("Вместимость пассажиров: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // очистка буфера
        System.out.print("Тип топлива: ");
        String fuel = scanner.nextLine();

        Car userCar = new Car(brand, model, year, capacity, fuel, true);
        System.out.println("\nСозданный автомобиль:");
        userCar.displayInfo();

        // 7. Демонстрация специфических методов
        System.out.println("7. СПЕЦИФИЧЕСКИЕ МЕТОДЫ КЛАССОВ:");
        car1.enableAirConditioning();
        car1.transportPassengers();

        truck1.loadCargo(15.0);
        truck1.loadCargo(30.0); // превышение грузоподъемности
        truck1.attachTrailer();

        motorcycle1.wheelie();
        motorcycle1.carryPassenger();

        scanner.close();

        System.out.println("\n=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
    }
}