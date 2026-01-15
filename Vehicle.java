import java.util.Scanner;

abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private static int count = 0;

    public Vehicle() {
        this.brand = "Неизвестно";
        this.model = "Неизвестно";
        this.year = 2024;
        count++;
    }

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        count++;
    }

    public abstract void startEngine();
    public abstract void stopEngine();

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }

    public static int getCount() { return count; }

    public void showInfo() {
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("Год: " + year);
    }
}

class Car extends Vehicle {
    private int seats;
    private String fuel;
    private boolean climateControl;

    public Car() {
        super();
        this.seats = 5;
        this.fuel = "Бензин";
        this.climateControl = true;
    }

    public Car(String brand, String model, int year, int seats, String fuel, boolean climateControl) {
        super(brand, model, year);
        this.seats = seats;
        this.fuel = fuel;
        this.climateControl = climateControl;
    }

    public void startEngine() {
        System.out.println("Автомобиль " + getBrand() + " завелся");
    }

    public void stopEngine() {
        System.out.println("Автомобиль " + getBrand() + " заглушен");
    }

    public void turnOnAC() {
        if (climateControl) {
            System.out.println("Кондиционер работает");
        } else {
            System.out.println("Кондиционера нет");
        }
    }

    public void carryPeople() {
        System.out.println("Перевозит " + seats + " человек");
    }

    public int getSeats() { return seats; }
    public String getFuel() { return fuel; }
    public boolean hasClimateControl() { return climateControl; }

    public void setSeats(int seats) { this.seats = seats; }
    public void setFuel(String fuel) { this.fuel = fuel; }
    public void setClimateControl(boolean climateControl) { this.climateControl = climateControl; }

    public void showInfo() {
        super.showInfo();
        System.out.println("Мест: " + seats);
        System.out.println("Топливо: " + fuel);
        System.out.println("Кондиционер: " + (climateControl ? "есть" : "нет"));
        System.out.println("---");
    }
}

class Truck extends Vehicle {
    private double loadCapacity;
    private int axles;
    private boolean trailer;

    public Truck() {
        super();
        this.loadCapacity = 10.0;
        this.axles = 2;
        this.trailer = false;
    }

    public Truck(String brand, String model, int year, double loadCapacity, int axles, boolean trailer) {
        super(brand, model, year);
        this.loadCapacity = loadCapacity;
        this.axles = axles;
        this.trailer = trailer;
    }

    public void startEngine() {
        System.out.println("Грузовик " + getBrand() + " завелся");
    }

    public void stopEngine() {
        System.out.println("Грузовик " + getBrand() + " заглушен");
    }

    public void loadCargo(double weight) {
        if (weight <= loadCapacity) {
            System.out.println("Загружено " + weight + " тонн");
        } else {
            System.out.println("Перегруз! Максимум " + loadCapacity + " тонн");
        }
    }

    public void connectTrailer() {
        if (trailer) {
            System.out.println("Прицеп подключен");
        } else {
            System.out.println("Прицеп не предусмотрен");
        }
    }

    public double getLoadCapacity() { return loadCapacity; }
    public int getAxles() { return axles; }
    public boolean hasTrailer() { return trailer; }

    public void setLoadCapacity(double loadCapacity) { this.loadCapacity = loadCapacity; }
    public void setAxles(int axles) { this.axles = axles; }
    public void setTrailer(boolean trailer) { this.trailer = trailer; }

    public void showInfo() {
        super.showInfo();
        System.out.println("Грузоподъемность: " + loadCapacity + " т");
        System.out.println("Оси: " + axles);
        System.out.println("Прицеп: " + (trailer ? "есть" : "нет"));
        System.out.println("---");
    }
}

class Motorcycle extends Vehicle {
    private String type;
    private boolean passengerSeat;
    private int engineSize;

    public Motorcycle() {
        super();
        this.type = "Спортивный";
        this.passengerSeat = false;
        this.engineSize = 600;
    }

    public Motorcycle(String brand, String model, int year, String type, boolean passengerSeat, int engineSize) {
        super(brand, model, year);
        this.type = type;
        this.passengerSeat = passengerSeat;
        this.engineSize = engineSize;
    }

    public void startEngine() {
        System.out.println("Мотоцикл " + getBrand() + " завелся");
    }

    public void stopEngine() {
        System.out.println("Мотоцикл " + getBrand() + " заглушен");
    }

    public void doWheelie() {
        System.out.println("Мотоцикл поднял переднее колесо");
    }

    public void checkPassenger() {
        if (passengerSeat) {
            System.out.println("Можно возить пассажира");
        } else {
            System.out.println("Пассажира возить нельзя");
        }
    }

    public String getType() { return type; }
    public boolean hasPassengerSeat() { return passengerSeat; }
    public int getEngineSize() { return engineSize; }

    public void setType(String type) { this.type = type; }
    public void setPassengerSeat(boolean passengerSeat) { this.passengerSeat = passengerSeat; }
    public void setEngineSize(int engineSize) { this.engineSize = engineSize; }

    public void showInfo() {
        super.showInfo();
        System.out.println("Тип: " + type);
        System.out.println("Пассажир: " + (passengerSeat ? "можно" : "нельзя"));
        System.out.println("Объем: " + engineSize + " см³");
        System.out.println("---");
    }
}

