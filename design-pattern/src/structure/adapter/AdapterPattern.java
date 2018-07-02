package structure.adapter;

class Adaptee {
    public void specificRequest() {
        System.out.println("adaptee`s specificRequest");
    }
}

interface Target {
    void request();
}

class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        System.out.println("implements Adapter`s request()");
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.request();
        adapter.specificRequest();
    }
}
