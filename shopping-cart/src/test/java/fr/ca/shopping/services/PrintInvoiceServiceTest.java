package fr.ca.shopping.services;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import fr.ca.shopping.common.data.DataFactory;
import fr.ca.shopping.domain.Cart;
import fr.ca.shopping.services.invoice.IPrintInvoice;
import fr.ca.shopping.services.invoice.PrintInvoiceService;

public class PrintInvoiceServiceTest {

	@Test(dataProvider=DataFactory.CARTS_PROVIDER,
			dataProviderClass=DataFactory.class)
	public void printCartInvoice(Cart cart) throws Exception {
		// Arrange
		IPrintInvoice printInvoiceService = new PrintInvoiceService();
		File testResult = DataFactory.getTestResultFile("/test/result/"+ cart.name +".txt");
		
		// Act
		File invoice = printInvoiceService.print(cart);

		// Assert
		assertTrue(FileUtils.contentEquals(testResult, invoice));
	}
}
