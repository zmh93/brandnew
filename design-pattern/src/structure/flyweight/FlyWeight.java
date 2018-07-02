package structure.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *  享元工厂：用于创建具体享元类，维护相同的享元对象。它保证相同的享元对象可以被系统共享。
 *      即，其内部使用了类似单例模式的方法，当请求对象已经存在时，直接返回对象，不存在时，在创建对象。
 *  抽象享元：定义需要共享的对象业务接口。享元类被创建出来总是为了实现某些特定的业务逻辑，而抽象享元便定义这些逻辑的语义行为。
 *  具体享元类：实现抽象享元类的接口，完成某一具体逻辑。
 *  客户端：使用享元模式的组件，通过享元工厂取得享元对象。
 * @createDate 2018/7/2
 */
public interface FlyWeight {
    void cell();
}

class BookOrder implements FlyWeight {
    private String name;

    BookOrder(String name) {
        this.name = name;
    }

    @Override
    public void cell() {
        System.out.println("卖了一本书，书名为'" + this.name + "'");
    }
}

class FlyWeightFactory {

    private        Map<String, FlyWeight> bookPools = new HashMap<String, FlyWeight>();
    private static FlyWeightFactory       factory   = new FlyWeightFactory();

    public static FlyWeightFactory getInstance() {
        return factory;
    }

    //添加订单
    public FlyWeight getOrder(String bookName) {
        FlyWeight order = null;
        if (bookPools.containsKey(bookName)) {
            order = bookPools.get(bookName);
        } else {
            order = new BookOrder(bookName);
            bookPools.put(bookName, order);
        }
        return order;
    }

    public int getTotalObjects() {
        return bookPools.size();
    }

}

class PatternTest {

    private static List<FlyWeight>  orders = new ArrayList<FlyWeight>();
    private static FlyWeightFactory factory;

    public static void main(String[] args) {
        factory = FlyWeightFactory.getInstance();
        takeOrders("三国演义");
        takeOrders("水浒传");
        takeOrders("封神榜");
        takeOrders("三体");
        takeOrders("红楼梦");
        takeOrders("三国演义");
        takeOrders("封神榜");
        takeOrders("水浒传");

        for (FlyWeight order : orders) {
            order.cell();
        }
        // 打印生成的订单java对象数量
        System.out.println("\n客户一共买了 " + orders.size() + " 本书! ");
        // 打印生成的订单java对象数量
        System.out.println("共生成了 " + factory.getTotalObjects()
                + " 个 FlyWeight java对象! ");
    }

    private static void takeOrders(String bookName) {
        orders.add(factory.getOrder(bookName));
    }

}
