package singleton;

public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
    }

    public SingletonHungry getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonHungry s = new SingletonHungry();
        SingletonHungry i1 = s.getInstance();
        SingletonHungry i2 = s.getInstance();
        System.out.println(i1 == i2);
        System.out.println(i1 == new SingletonHungry());
    }
}
