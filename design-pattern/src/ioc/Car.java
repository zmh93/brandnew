package ioc;

/**
 * ioc就是当依赖某个类的某种方法时，直接声明一个该类型的变量，在构造器中初始化该变量。
 * 这样当修改该类时，只要不修改原有的属性，就不要修改其被引用的地方
 *
 * @createDate 2018/7/3
 */
public class Car {
    private Engine engine;

    public Car() {
        this.engine = new Engine();
    }

    public static void main(String[] args) {
        new Car().engine.run();
    }
}

class Engine {
    private Screw screw;

    void run() {
        System.out.println("engine is running");
    }

    Engine() {
        this.screw = new Screw();
    }
}

class Screw {
    private Iron iron;

    Screw() {
        this.iron = new Iron();
    }
}

class Iron {
    Iron() {
        System.out.println("Iron is made");
    }
}
