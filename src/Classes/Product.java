package Classes;

public abstract class Product {
	
	protected double price;
	protected String name;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }
    
    public abstract String toString();
    
    public abstract double getPrice();
}
