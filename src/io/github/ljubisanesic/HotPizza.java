package io.github.ljubisanesic;

public class HotPizza extends Pizza {

	
	public HotPizza() {
		this.setName("Hot Pizza");
	}
	
	public HotPizza(double price, String sizeOfPizza) {
		this();
		this.setPrice(price);
		this.setSizeOfPizza(sizeOfPizza);
	}
}
