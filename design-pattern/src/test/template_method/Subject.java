package test.template_method;

public class Subject {
    private TemplateMethod templateMethod;

    public Subject(TemplateMethod templateMethod) {
        this.templateMethod = templateMethod;
    }

    public void doSth() {
        templateMethod.doSth();
    }

    public void changeMethod(TemplateMethod templateMethod) {
        this.templateMethod = templateMethod;
    }
}
