import java.util.Scanner;

public class TransportProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car1 = new Car("Toyota", "Camry", 2023, 5, "Бензин", true);
        Truck truck1 = new Truck("Volvo", "FH16", 2022, 25.5, 3, true);
        Motorcycle bike1 = new Motorcycle("Yamaha", "R6", 2023, "Спортивный", false, 600);

        car1.showInfo();
        truck1.showInfo();
        bike1.showInfo();

        System.out.println("Всего машин: " + Vehicle.getCount());

        Vehicle[] vehicles = {car1, truck1, bike1};
        for (Vehicle v : vehicles) {
            v.startEngine();
            v.stopEngine();
        }

        System.out.print("Введите марку машины: ");
        String brand = scanner.nextLine();
        System.out.print("Введите модель: ");
        String model = scanner.nextLine();
        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        Car userCar = new Car(brand, model, year, 5, "Бензин", true);
        userCar.showInfo();

        car1.turnOnAC();
        truck1.loadCargo(15.0);
        bike1.doWheelie();

        scanner.close();
    }
}
