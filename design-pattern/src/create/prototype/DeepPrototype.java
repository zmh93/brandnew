package create.prototype;

interface Proto {
    Object clone();
}
class ConcreteProto1 implements Proto {
    public Object clone() {
        // 最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        Proto prototype = new ConcreteProto1();
        return prototype;
    }
}
class ConcreteProto2 implements Proto {
    public Object clone() {
        //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        Proto prototype = new ConcreteProto2();
        return prototype;
    }
}

public class DeepPrototype {
    public static void main(String[] args) {
        Proto          p1     = new ConcreteProto1();
        Proto          p2     = new ConcreteProto2();
        ConcreteProto1 clone1 = (ConcreteProto1) p1.clone();
        System.out.println(p1);
        System.out.println(clone1);
        ConcreteProto2 clone2 = (ConcreteProto2) p2.clone();
        System.out.println(p2);
        System.out.println(clone2);
    }
}
