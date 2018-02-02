package fr.ca.shopping.domain;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import fr.ca.shopping.common.data.DataFactory;

public class PriceTest {

	@Test(dataProvider=DataFactory.PRICES_PROVIDER,
			dataProviderClass=DataFactory.class)
	public void validatePriceTTC(Product product, double priceTTC) throws Exception {
		// Arrange

		// Act

		// Assert
		assertEquals(product.price.getPriceTTC().doubleValue(), priceTTC);
	}
	
	@Test(dataProvider=DataFactory.CART_PRODUCTS_PROVIDER,
			dataProviderClass=DataFactory.class)
	public void validateCartProduct(CartProduct cartProduct, double priceTTC) throws Exception {
		// Arrange
		

		// Act
		cartProduct.validate();

		// Assert
		assertEquals(cartProduct.price.getPriceTTC().doubleValue(), priceTTC);
	}
}
