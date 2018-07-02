package structure.decorator;

public abstract class Car {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car() {

    }
    public Car(int price) {
        this.price = price;
    }

    public abstract void made();
}
