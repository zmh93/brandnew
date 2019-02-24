package test.observer;

import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subject {
    public static TheState state;
    private List<Observer> list = new ArrayList<>();

    public void add(Observer observer) {
        list.add(observer);
    }

    public void delete(Observer observer) {
        list.remove(observer);
    }

    public void doSth() {
        Random random = new Random();
        TheState[] values = TheState.values();
        state = values[random.nextInt(4)];
        updateState();
    }

    private void updateState() {
        for (Observer observer : list) {
            observer.update();
        }
    }


}
