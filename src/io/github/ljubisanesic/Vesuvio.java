package io.github.ljubisanesic;

public class Vesuvio extends Pizza {

	
	public Vesuvio() {
		this.setName("Vesuvio");
	}
	
	public Vesuvio(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}
}
