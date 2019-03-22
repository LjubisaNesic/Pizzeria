package io.github.ljubisanesic;

public class Capricciosa extends Pizza {
	
	
	public Capricciosa() {
		this.setName("Capricciosa");
	}
	
	public Capricciosa(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}

}
