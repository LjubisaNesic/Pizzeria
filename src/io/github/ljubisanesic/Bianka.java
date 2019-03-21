package io.github.ljubisanesic;

public class Bianka extends Pizza {
	
	
	public Bianka() {
		this.setName("Bianca");
	}
	
	public Bianka(double price, String sizeOfPizza) {
		this();
		setPrice(price);
		setSizeOfPizza(sizeOfPizza);
	}

}
