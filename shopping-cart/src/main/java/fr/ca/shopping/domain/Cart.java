package fr.ca.shopping.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cart {
	private static final Logger LOGGER = LoggerFactory.getLogger(Cart.class);
	public String name;
	private Collection<CartProduct> cartProducts = new ArrayList<CartProduct>();

	public Cart(String name) {
		super();
		this.name = name;
	}


	public Cart addProduct(Product product, int quantity) {
		this.cartProducts.add(new CartProduct(product, quantity));
		
		return this;
	}
	
	public Collection<CartProduct> getCartProducts() {
		return cartProducts;
	}


	public void validate() {
		LOGGER.info("Validate cart and update prices");
		
		cartProducts.forEach(cartProduct -> cartProduct.validate());
	}
	
	public BigDecimal getTotalTTC() {
		return cartProducts.stream()
			.map(cartProduct -> cartProduct.price.getPriceTTC())
			.reduce(new BigDecimal(0), BigDecimal::add);
	}
	
	public BigDecimal getTotalVAT() {
		return cartProducts.stream()
			.map(cartProduct -> cartProduct.price.getPriceVAT())
			.reduce(new BigDecimal(0), BigDecimal::add);
	}
}
