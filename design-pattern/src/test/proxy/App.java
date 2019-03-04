package test.proxy;

public class App {
    public static void main(String[] args) {
        FirstSchool firstSchool = new FirstSchool();
        SecondSchool secondSchool = new SecondSchool();
        SchoolProxy firstSchoolProxy = new SchoolProxy(firstSchool, 3);
        firstSchoolProxy.recruit();
        firstSchoolProxy.recruit();
        firstSchoolProxy.recruit();
        firstSchoolProxy.recruit();

    }
}
