package structure.bridge;

public class Consumer {
    public static void main(String[] args) {
        Engine engineA = new EngineA();
        Engine engineB = new EngineB();
        Car   carA    = new CarA(engineA);
        carA.made();
        carA.setEngine(engineB);
        carA.made();
        new CarB(engineB).made();
    }
}
