package test.observer2;

public class App {
    public static void main(String[] args) {
        Boyfriend bf = new Boyfriend();
        Neighbour n = new Neighbour();
        Subject   subject = new Subject();
        subject.add(bf);
        subject.add(n);
        subject.meet();
        subject.meet();
        subject.meet();
    }
}
