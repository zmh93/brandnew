package structure.decorator;

public class CarA extends Car {
    public CarA(int price) {
        super(price);
    }

    @Override
    public void made() {
        System.out.println("CarA made");
    }
}
