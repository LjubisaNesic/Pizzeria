package io.github.ljubisanesic;

public class Cacciatore extends Pizza {

	
	public Cacciatore() {
		this.setName("Cacciatore");
	}
	
	public Cacciatore(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}
}
