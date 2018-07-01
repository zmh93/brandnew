package singleton;

import java.util.Optional;

public class SingletonWealth {
    private static SingletonWealth instance;

    private SingletonWealth() {}

    //加synchronize 是为了防止多个线程同时调用导致创建多个实例
    public synchronized SingletonWealth getInstance() {
        if (null == instance) {
            instance = new SingletonWealth();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonWealth s = new SingletonWealth();
        SingletonWealth i1 = s.getInstance();
        SingletonWealth i2 = s.getInstance();
        System.out.println(i1 == i2);
        System.out.println(i1 == new SingletonWealth());
    }

}
