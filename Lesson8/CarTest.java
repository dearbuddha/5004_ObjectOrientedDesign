package Lesson8;

public class CarTest {
    public static void main(String[] args) {
        Car a = new Car("BMW", "X1", 12, 28);
        Car b = new Car("Ford", "Focus", 10, 32);
        ElectricCar c = new ElectricCar("Tesla", "Model 3", 20, 3);
        HybridCar d = new HybridCar("Chevy", "Bolt", 13, 20, 3, 28);
        a.addFuel(5);
        b.addFuel(10);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(b.drive(400));
        System.out.println(d);
    }
}

class Car implements Auto {
    public Car(String make, String model, int cap, int mpg) {
        this.make = make;
        this.model = model;
        this.capacity = cap;
        this.mpg = mpg;
    }
    private String make;
    private String model;
    private int capacity;
    private int fuel;
    // efficiency
    private int mpg;
    public int getFuel() {
        return this.fuel;
    }

    public void addFuel(int x) {
        if (x < 0) {
            return;
        }
        this.fuel = Math.min(fuel + x, capacity);
    }

    // drive the car for d miles
    public boolean drive(int d) {
        if (d >= 0 && d / mpg <= fuel) {
            fuel -= d/mpg;
            return true;
        }
        return false;
    }

    public String toString() {
        return this.make + " " + this.model + ", remaining fuel " + getFuel();
    }
}

class ElectricCar implements ElectricAuto {
    public ElectricCar(String make, String model, int bat, int kwhpm) {
        this.make = make;
        this.model = model;
        this.battery = bat;
        this.kwhpm = kwhpm;
    }
    private String make;
    private String model;
    private int battery;
    // measured in kwh
    private int charge;
    // efficiency
    private int kwhpm;
    public int getCharge() {
        return this.charge;
    }

    public void addCharge(int x) {
        if (x < 0) {
            return;
        }
        this.charge = Math.min(charge + x, battery);
    }

    // drive the car for d miles
    public boolean drive(int d) {
        if (d >= 0 && d * kwhpm <= charge) {
            charge -= d * kwhpm;
            return true;
        }
        return false;
    }

    public String toString() {
        return this.make + " " + this.model + ", remaining charge " + getCharge();
    }
}


// The diamond problem
//      A
//     / \
//    B   C
//    \  /
//     D
interface Auto {
    boolean drive(int d);
    void addFuel(int x);
}

interface ElectricAuto {
    boolean drive(int d);
    void addCharge(int x);
}

class HybridCar implements Auto, ElectricAuto {
    public HybridCar(String make, String model, int cap, int bat, int kwhpm, int mpg) {
        this.make = make;
        this.model = model;
        this.battery = bat;
        this.capacity = cap;
        this.kwhpm = kwhpm;
        this.mpg = mpg;
    }
    private String make;
    private String model;
    private int capacity;
    private int battery;
    // measured in kwh
    private int charge;
    private int fuel;
    // efficiency
    private int kwhpm;
    private int mpg;

    public int getCharge() {
        return this.charge;
    }

    public void addCharge(int x) {
        if (x < 0) {
            return;
        }
        this.charge = Math.min(charge + x, battery);
    }

    public int getFuel() {
        return this.fuel;
    }

    public void addFuel(int x) {
        if (x < 0) {
            return;
        }
        this.fuel = Math.min(fuel + x, capacity);
    }

    // drive the car for d miles
    // assumption: use electricity first
    public boolean drive(int d) {
        int range = getFuel() * mpg + getCharge() / kwhpm;
        if (d >= 0 && d <= range) {
            int remDist = Math.max(d - getCharge() / kwhpm, 0);
            charge -= (d - remDist) * kwhpm;
            fuel -= remDist / mpg;
            return true;
        }
        return false;
    }

    public String toString() {
        return this.make + " " + this.model + ", remaining charge " + getCharge() + ", remaining fuel " + getFuel();
    }
}