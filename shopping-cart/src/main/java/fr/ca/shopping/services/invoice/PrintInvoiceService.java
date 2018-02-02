package fr.ca.shopping.services.invoice;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ca.commons.io.FilePrinter;
import fr.ca.commons.io.PrintAPI;
import fr.ca.commons.io.Printer;
import fr.ca.shopping.domain.Cart;
import fr.ca.shopping.domain.InvoicePrinter;

public class PrintInvoiceService implements IPrintInvoice {
	private static final Logger LOGGER = LoggerFactory.getLogger(PrintInvoiceService.class);

	/* (non-Javadoc)
	 * @see fr.ca.shopping.services.IPrintInvoice#print(fr.ca.shopping.domain.Cart)
	 */
	@Override
	public File print(Cart cart) throws Exception {
		LOGGER.info("Print cart invoice");
		
		cart.validate();
		
		File file = File.createTempFile(cart.name +" - ", ".txt");
		
		PrintAPI printAPI = new InvoicePrinter(cart);
		Printer printer = new FilePrinter(printAPI, file);
		
		printer.print();
		
		return file;
	}

}
