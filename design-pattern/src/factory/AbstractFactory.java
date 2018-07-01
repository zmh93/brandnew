package factory;


//发动机以及型号
interface Engine {

}
class EngineA implements Engine{
    public EngineA(){
        System.out.println("制造-->EngineA");
    }
}
class EngineB implements Engine{
    public EngineB(){
        System.out.println("制造-->EngineB");
    }
}

//空调以及型号
interface Aircondition {

}
class AirconditionA implements Aircondition{
    public AirconditionA(){
        System.out.println("制造-->AirconditionA");
    }
}
class AirconditionB implements Aircondition{
    public AirconditionB(){
        System.out.println("制造-->AirconditionB");
    }
}


//为宝马320系列生产配件
class FactoryBMW320 implements AbstractFactory{

    @Override
    public Engine createEngine() {
        return new EngineA();
    }
    @Override
    public Aircondition createAircondition() {
        return new AirconditionA();
    }
}
//宝马523系列
class FactoryBMW523 implements AbstractFactory {

    @Override
    public Engine createEngine() {
        return new EngineB();
    }
    @Override
    public Aircondition createAircondition() {
        return new AirconditionB();
    }
}
public abstract interface AbstractFactory {
    //制造发动机
    Engine createEngine();
    //制造空调
    Aircondition createAircondition();

    public static void main(String[] args) {
        AbstractFactory factory1 = new FactoryBMW320();
        AbstractFactory factory2 = new FactoryBMW523();
        factory1.createEngine();
        factory1.createAircondition();
        System.out.println("----------------------------");
        factory2.createEngine();
        factory2.createAircondition();
    }
}
