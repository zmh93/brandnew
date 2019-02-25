package test.observer2;

import static test.observer2.Subject.STATE;

public class Boyfriend implements Observer {
    @Override
    public void update() {
        switch (STATE) {
            case CLOTHES_OFF:
                System.out.println("bf: 不好看");
                break;
            case KISS:
                System.out.println("bf: 没刷牙啊");
                break;
            case FUCK:
                System.out.println("bf: 好松");
                break;
            case CLIMIX:
                System.out.println("bf: 啥? 根本没有过好吗");
                break;
                default:break;
        }
    }
}
