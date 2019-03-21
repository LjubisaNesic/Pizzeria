package io.github.ljubisanesic;

public class Bianca extends Pizza {
	
	
	public Bianca() {
		this.setName("Bianca");
	}
	
	public Bianca(double price, String sizeOfPizza) {
		this();
		setPrice(price);
		setSizeOfPizza(sizeOfPizza);
	}

}
