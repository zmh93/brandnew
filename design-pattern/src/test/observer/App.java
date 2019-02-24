package test.observer;

public class App {
    public static void main(String[] args) {
        Boss boss = new Boss();
        PD   pd   = new PD();
        Subject subject = new Subject();
        subject.add(boss);
        subject.add(pd);
        subject.doSth();
        subject.doSth();
        subject.doSth();
    }
}
