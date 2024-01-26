package Classes;

public class Rate extends Product {
	
	public Rate(double price, String name) {
        super(price, name);
    }

	@Override
    public String toString() {
        return this.name;
    }
	
	@Override
    public double getPrice() {
        return this.price;
    }
}
