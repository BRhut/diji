package fr.ca.shopping.common.data;

import java.io.File;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fr.ca.shopping.domain.Cart;
import fr.ca.shopping.domain.CartProduct;
import fr.ca.shopping.domain.Product;
import fr.ca.shopping.domain.ProductType;

@Test
public class DataFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataFactory.class);
	public static final String PRICES_PROVIDER = "pricesProvider";
	public static final String CART_PRODUCTS_PROVIDER = "cartProductsProvider";
	public static final String CARTS_PROVIDER = "cartsProvider";
	

	@DataProvider(name=PRICES_PROVIDER)
	public Object[][] providePrices() {
		return new Object[][] {
			{new Product(ProductType.BOOK, "livres", 12.49, false), 13.75}, 
			{new Product(ProductType.OTHER, "CD musical", 14.99, false), 18},
			{new Product(ProductType.OTHER, "barres de chocolat", 0.85, false), 1.05},
		};
	}
	
	@DataProvider(name=CART_PRODUCTS_PROVIDER)
	public Object[][] provideCartProducts() {
		return new Object[][] {
			{new CartProduct(new Product(ProductType.BOOK, "livres", 12.49, false), 2), 27.5}, 
			{new CartProduct(new Product(ProductType.OTHER, "CD musical", 14.99, false), 1), 18},
			{new CartProduct(new Product(ProductType.OTHER, "barres de chocolat", 0.85, false), 3), 3.1},
		};
	}
	
	
	@DataProvider(name=CARTS_PROVIDER)
	public Object[][] provideCarts() {
		Cart cart1 = new Cart("Cart 1")
			.addProduct(new Product(ProductType.BOOK, "livres", 12.49, false), 2)
			.addProduct(new Product(ProductType.OTHER, "CD musical", 14.99, false), 1)
			.addProduct(new Product(ProductType.OTHER, "barres de chocolat", 0.85, false), 3);
		
		Cart cart2 = new Cart("Cart 2")
				.addProduct(new Product(ProductType.OTHER, "boîtes de chocolats importée", 10, true), 2)
				.addProduct(new Product(ProductType.OTHER, "flacons de parfum importé", 47.50, true), 3);
		
		Cart cart3 = new Cart("Cart 3")
				.addProduct(new Product(ProductType.OTHER, "flacons de parfum importé", 27.99, true), 2)
				.addProduct(new Product(ProductType.OTHER, "flacon de parfum", 18.99, false), 1)
				.addProduct(new Product(ProductType.OTHER, "boîtes de pilules contre la migraine", 9.75, false), 3)
				.addProduct(new Product(ProductType.OTHER, "boîtes de chocolats importés", 11.25, true), 2);
		
		return new Object[][] {
			{cart1}, 
			{cart2},
			{cart3}
		};
	}
	
	

	public static File getTestResultFile(String name) throws URISyntaxException {
		return new File(DataFactory.class.getResource(name).toURI());
	}

}
