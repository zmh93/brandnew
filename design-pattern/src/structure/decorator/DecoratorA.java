package structure.decorator;

public class DecoratorA extends Decorator {
    public DecoratorA(Car car) {
        super(car);
    }

    @Override
    public void made() {
        getCar().made();
        System.out.println("新增功能A");
    }

    @Override
    public void price() {
        System.out.println("售价"+(getCar().getPrice() + 30));
    }
}
