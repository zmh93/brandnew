package create.factory;

interface Factory {
    Cat createCat();
}

class Factory1 implements Factory {
    public Cat createCat() {
        return new Cat1();
    }
}

class Factory2 implements Factory {
    public Cat createCat() {
        return new Cat2();
    }
}

abstract class Cat {
}

class Cat1 extends Cat {
    public Cat1() {
        System.out.println("Cat1 has been made!");
    }
}

class Cat2 extends Cat {
    public Cat2() {
        System.out.println("Cat2 has been made! ");
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Factory f1 = new Factory1();
        Factory f2 = new Factory2();
        f1.createCat();
        f2.createCat();
    }
}
