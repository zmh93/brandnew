package structure.decorator;

public class CarB extends Car {
    public CarB(int price) {
        super(price);
    }

    @Override
    public void made() {
        System.out.println("CarB made");
    }
}
