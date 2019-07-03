package test.template_method;

public class App {
    public static void main(String[] args) {
        Subject subject = new Subject(new CommonMethod());
        subject.doSth();
        subject.changeMethod(new ExcellentMethod());
        subject.doSth();
    }
}
