package test.observer;

public class LiMing implements Observer {

    @Override
    public void updateSubjectState() {
        switch (Subject.currentState) {
            case NO_JOB:
                System.out.println("liming: enjoy this leisure time of no job");
                break;
            case LOSE_JOB:
                System.out.println("liming: haven a period of unhappy time");
                break;
            case WORKING:
                System.out.println("liming: nine nine six is not human do");
                break;
            case UNREPLACABLE:
                System.out.println("liming: it feels very good to has a important place");
                break;
            default:
                System.out.println("ERROR: sth wrong here for liming!");
        }
    }
}
