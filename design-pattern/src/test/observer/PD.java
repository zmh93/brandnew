package test.observer;

public class PD implements Observer{
    @Override
    public void update() {
        switch (Subject.state) {
            case GORGEOUS:
                System.out.println("产品: 看见个美女很开心");break;
            case UGLY:
                System.out.println("产品: 这tm以后咋工作");break;
            case PLAIN:
                System.out.println("产品: 不知道这人脾气咋样");break;
            case BEAUTIFUL:
                System.out.println("产品: 好啊");break;
            default:break;
        }
    }
}
