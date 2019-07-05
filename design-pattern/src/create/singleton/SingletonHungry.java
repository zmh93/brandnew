package create.singleton;

public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonHungry i1 = SingletonHungry.getInstance();
        SingletonHungry i2 = SingletonHungry.getInstance();
        System.out.println(i1 == i2);
        System.out.println(i1 == SingletonHungry.getInstance());
    }
}
