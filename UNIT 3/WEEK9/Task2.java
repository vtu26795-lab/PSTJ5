import java.util.*;

// Base class
class Vehicle {
    int vehicleId;
    String modelName;
    double baseRent;

    Vehicle(int vehicleId, String modelName, double baseRent) {
        this.vehicleId = vehicleId;
        this.modelName = modelName;
        this.baseRent = baseRent;
    }

    double calculateRent() {
        return baseRent;
    }

    void display() {
        System.out.println("Vehicle ID: " + vehicleId +
                ", Model: " + modelName +
                ", Total Rent: " + calculateRent());
    }
}

// Car subclass
class Car extends Vehicle {
    int seats;

    Car(int vehicleId, String modelName, double baseRent, int seats) {
        super(vehicleId, modelName, baseRent);
        this.seats = seats;
    }

    double calculateRent() {
        return baseRent + (seats * 100);
    }
}

// Bike subclass
class Bike extends Vehicle {
    int engineCapacity;

    Bike(int vehicleId, String modelName, double baseRent, int engineCapacity) {
        super(vehicleId, modelName, baseRent);
        this.engineCapacity = engineCapacity;
    }

    double calculateRent() {
        return baseRent + (engineCapacity * 2);
    }
}

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Vehicle> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            int id = sc.nextInt();
            String model = sc.next();
            double base = sc.nextDouble();

            if(type == 'C') {
                int seats = sc.nextInt();
                list.add(new Car(id, model, base, seats));
            } 
            else if(type == 'B') {
                int capacity = sc.nextInt();
                list.add(new Bike(id, model, base, capacity));
            }
        }

        for(Vehicle v : list) {
            v.display();
        }

        sc.close();
    }
}