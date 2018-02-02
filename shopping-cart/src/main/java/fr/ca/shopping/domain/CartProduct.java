package fr.ca.shopping.domain;

import java.math.BigDecimal;

public class CartProduct {
	public Product product;
	public int quantity;
	
	public Price price;
	
	public CartProduct(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}



	public void validate() {
		this.price = new Price(product, 
			product.price.getPriceHT().multiply(BigDecimal.valueOf(quantity)).doubleValue());
	}
	
	
}
