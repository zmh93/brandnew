package test.observer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subject {
    public static State STATE;

    private List<Observer> list = new ArrayList<>();

    public void add(Observer observer) {
        list.add(observer);
    }

    public void remove(Observer observer) {
        list.remove(observer);
    }

    void meet() {
        State[] values = State.values();
        Random  random = new Random();
        STATE = values[random.nextInt(4)];
        this.updateState();
    }

    private void updateState() {
        for (Observer observer : list) {
            observer.update();
        }
    }
}
