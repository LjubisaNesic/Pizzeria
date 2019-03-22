package io.github.ljubisanesic;

public class Calzone extends Pizza {

	
	public Calzone() {
		this.setName("Calzone");
	}
	
	public Calzone(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}
}
