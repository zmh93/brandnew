package structure.decorator;

public class Test {
    public static void main(String[] args) {
        Decorator a = new DecoratorA(new CarA(20));
        a.made();
        a.price();
        new DecoratorA(new CarB(30)).price();
    }
}
