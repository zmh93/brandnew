package factory;


abstract class Car {
}

class Car1 extends Car {
    public Car1() {
        System.out.println("Car1 has been made!");
    }
}

class Car2 extends Car {
    public Car2() {
        System.out.println("Car2 has been made! ");
    }
}

public class SimpleFactory {
    public static SimpleFactory factory = new SimpleFactory();

    public Car createCar(String carName) {
        switch (carName) {
            case "car1":
                return new Car1();
            case "car2":
                return new Car2();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        SimpleFactory factory = SimpleFactory.factory;
        factory.createCar("car1");
        factory.createCar("car2");
        factory.createCar("ass hole");
    }
}
