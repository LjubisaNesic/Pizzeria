package io.github.ljubisanesic;

public class Siciliana extends Pizza {
	
	
	public Siciliana() {
		this.setName("Siciliana");
	}
	
	public Siciliana(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}

}
