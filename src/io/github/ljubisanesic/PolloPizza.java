package io.github.ljubisanesic;

public class PolloPizza extends Pizza {
	
	public PolloPizza() {
		this.setName("Pollo Pizza");
	}
	
	public PolloPizza(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}

}
