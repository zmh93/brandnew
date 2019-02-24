package test.observer;

public class Boss implements Observer {
    @Override
    public void update() {
        switch (Subject.state) {
            case GORGEOUS:
                System.out.println("老板:新来的职员很漂亮,想嫖");break;
            case UGLY:
                System.out.println("老板: 这他妈谁招的人");break;
            case PLAIN:
                System.out.println("老板: 以后能提高下标准吗");break;
            case BEAUTIFUL:
                System.out.println("老板: 基本满意");break;
                default:break;
        }
    }
}
