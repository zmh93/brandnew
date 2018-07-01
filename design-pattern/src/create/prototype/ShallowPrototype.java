package create.prototype;

abstract class Prototype implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class ConcretePrototype1 extends Prototype {
    public static int classFlag = 1;

    public int getClassFlag() {
        return classFlag;
    }

    public Object clone() throws CloneNotSupportedException {
        return (ConcretePrototype1) super.clone();
    }
}

class ConcretePrototype2 extends Prototype {
    public static int classFlag = 2;

    public int getClassFlag() {
        return classFlag;
    }

    public Object clone() throws CloneNotSupportedException {
        return (ConcretePrototype2) super.clone();
    }
}

/**
 * 使用原型模式创建对象比直接new一个对象在性能上要好的多，因为Object类的clone方法是一个本地方法，
 * 它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
 * 所以在需要重复地创建相似对象时可以考虑使用原型模式。比如需要在一个循环体内创建对象，
 * 假如对象创建过程比较复杂或者循环次数很多的话，使用原型模式不但可以简化创建过程，而且可以使系统的整体性能提高很多。
 * @createDate 2018/7/2
 */
public class ShallowPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype          p1     = new ConcretePrototype1();
        Prototype          p2     = new ConcretePrototype2();
        ConcretePrototype1 clone1 = (ConcretePrototype1) p1.clone();
        System.out.println(clone1.getClassFlag());
        ConcretePrototype2 clone2 = (ConcretePrototype2) p2.clone();
        System.out.println(clone2.getClassFlag());
    }
}

