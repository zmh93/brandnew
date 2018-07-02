package structure.bridge;

public class CarB extends Car {
    public CarB(Engine engine) {
        super(engine);
    }

    @Override
    public void made() {
        getEngine().installEngine();
        System.out.println("CarB made");
    }
}
