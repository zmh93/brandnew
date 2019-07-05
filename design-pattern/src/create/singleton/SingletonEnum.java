package create.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum SingletonEnum {
    INSTANCE;

    public void intro() {
        System.out.println("this is a enum instance");
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        List<Callable<SingletonEnum>> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add(()-> {
                SingletonEnum instance = SingletonEnum.INSTANCE;
                System.out.println(instance);
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