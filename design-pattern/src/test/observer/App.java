package test.observer;

public class App {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(new LiMing());
        subject.addObserver(new YangChang());
        subject.addObserver(new MengHui());

        for (int i = 0; i < 4; i++) {
            subject.changeState();
        }
    }
}
