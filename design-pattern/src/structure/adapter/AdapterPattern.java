package structure.adapter;

class Adaptee {
    public void specificRequest() {
        System.out.println("adaptee`s specificRequest");
    }
}

interface Target {
    void request();
}

interface Target2 {
    void request2();
}

class Adapter extends Adaptee implements Target,Target2 {

    @Override
    public void request() {
        System.out.println("implements Adapter`s request()");
    }

    @Override
    public void request2() {
        System.out.println("this is target2`s define method");
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.request();
        adapter.specificRequest();
    }
}
