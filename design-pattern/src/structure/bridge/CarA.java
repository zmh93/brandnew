package structure.bridge;

public class CarA extends Car {
    public CarA(Engine engine) {
        super(engine);
    }

    @Override
    public void made() {
        getEngine().installEngine();
        System.out.println("CarA made");
    }
}
