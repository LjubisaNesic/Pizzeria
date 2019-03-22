package io.github.ljubisanesic;

public class PikadoPizza extends Pizza {

	
	public PikadoPizza() {
		this.setName("Pikado Pizza");
	}
	
	public PikadoPizza(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}
}
