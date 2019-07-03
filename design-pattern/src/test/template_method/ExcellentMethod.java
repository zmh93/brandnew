package test.template_method;

public class ExcellentMethod extends TemplateMethod {
    @Override
    public void prepare() {
        System.out.println(this.getClass().getSimpleName() + " is prepared");
    }

    @Override
    public void ready() {
        System.out.println(this.getClass().getSimpleName() + " is ready");
    }

    @Override
    public void participate() {
        System.out.println(this.getClass().getSimpleName() + " is participate us");
    }

    @Override
    public void outcome() {
        System.out.println(this.getClass().getSimpleName() + "`s outcome is excellent ");
    }
}
