package test.observer2;

import static test.observer2.Subject.STATE;

public class Neighbour implements Observer {
    @Override
    public void update() {
        switch (STATE) {
            case CLOTHES_OFF:
                System.out.println("neighbour: 硬的顶不住");
                break;
            case KISS:
                System.out.println("neighbour: 爽");
                break;
            case FUCK:
                System.out.println("neighbour: 好爽");
                break;
            case CLIMIX:
                System.out.println("neighbour: 爽死了");
                break;
            default:
                break;
        }
    }
}
