package test.template_method;

public abstract class TemplateMethod {
    public abstract void prepare();

    public abstract void ready();

    public abstract void participate();

    public abstract void outcome();

    public void doSth() {
        prepare();
        ready();
        participate();
        outcome();
    }

}
