package structure.bridge;

public class Consumer {
    public static void main(String[] args) {
        Engine engineA = new EngineA();
        Engine engineB = new EngineB();
        new CarA(engineA).made();
        new CarA(engineB).made();
        new CarB(engineB).made();
    }
}
