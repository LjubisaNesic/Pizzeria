package io.github.ljubisanesic;

public class Margherita extends Pizza {
	
	

	public Margherita() {
		this.setName("Margherita");
	}

	public Margherita(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}

}
