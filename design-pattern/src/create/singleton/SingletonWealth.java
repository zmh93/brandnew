package create.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonWealth {
    private static SingletonWealth instance;

    private SingletonWealth() {}

    //多个线程同时调用可能导致创建多个实例
    public static SingletonWealth getInstance() {
        if (null == instance) {
            instance = new SingletonWealth();
            System.out.println(instance);
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        List<Callable<SingletonWealth>> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add(()-> {
                SingletonWealth instance = SingletonWealth.getInstance();
                return instance;
            });
        }
        executorService.invokeAll(list);
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(100);
        }

    }

}
