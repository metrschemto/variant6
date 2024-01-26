package Classes;
import java.util.List;

public class Application {
	
	protected double square;
	protected Product rate;
	protected List<Product> services;
	
	public Application(double square, Product rate, List<Product> services)
	{
		this.square = square;
		this.rate = rate;
		this.services = services;
	}
	
	public double Calculate()
	{
		double summ = 0;
		if (this.services.size()>0)
		{
			for(int i=0; i<this.services.size(); i++)
			{
				Product service = this.services.get(i);
				summ += service.getPrice();
			}
		}
		summ += (this.square * this.rate.getPrice());
		return summ;
	}
}
