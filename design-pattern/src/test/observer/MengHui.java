package test.observer;

public class MengHui implements Observer {

    @Override
    public void updateSubjectState() {
        switch (Subject.currentState) {
            case NO_JOB:
                System.out.println("MengHui: enjoy this leisure time of no job");
                break;
            case LOSE_JOB:
                System.out.println("MengHui: haven a period of unhappy time");
                break;
            case WORKING:
                System.out.println("MengHui: nine nine six is not human do");
                break;
            case UNREPLACABLE:
                System.out.println("MengHui: it feels very good to has a important place");
                break;
            default:
                System.out.println("ERROR: sth wrong here for MengHui!");
        }
    }
}
