package test.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subject {
    public static EnumSubjectState currentState;
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObeserver(Observer observer) {
        observerList.remove(observer);
    }

    public void changeState() {
        currentState = EnumSubjectState.values()[new Random().nextInt(EnumSubjectState.values().length)];
        for (Observer observer : observerList) {
            observer.updateSubjectState();
        }
    }
}
