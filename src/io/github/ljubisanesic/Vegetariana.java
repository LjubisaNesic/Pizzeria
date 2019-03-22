package io.github.ljubisanesic;

public class Vegetariana extends Pizza {

	
	public Vegetariana() {
		this.setName("Vegetariana");
	}
	
	public Vegetariana(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}
}
