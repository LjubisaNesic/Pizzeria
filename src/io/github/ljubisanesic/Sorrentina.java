package io.github.ljubisanesic;

public class Sorrentina extends Pizza {
	
	public Sorrentina() {
		this.setName("Sorrentina");
	}
	
	public Sorrentina(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}

}
