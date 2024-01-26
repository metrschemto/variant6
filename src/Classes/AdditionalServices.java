package Classes;

public class AdditionalServices extends Product {
	
	public AdditionalServices(double price, String name) {
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
