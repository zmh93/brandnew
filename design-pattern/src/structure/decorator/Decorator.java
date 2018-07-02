package structure.decorator;

public abstract class Decorator {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Decorator(Car car) {
        this.car = car;
    }

    public abstract void made();

    public abstract void price();
}
