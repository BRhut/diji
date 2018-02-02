package fr.ca.shopping.domain;

import java.math.BigDecimal;

import fr.ca.commons.io.PrintAPI;
import fr.ca.commons.io.Printer;

public class InvoicePrinter extends PrintAPI {
	private Cart cart;
	
	

	public InvoicePrinter(Cart cart) {
		super();
		this.cart = cart;
	}



	@Override
	protected void print(Printer printer) throws Exception {
		StringBuilder sb = new StringBuilder();
		for (CartProduct cartProduct : cart.getCartProducts()) {
			sb.append("* ")
				.append(cartProduct.quantity)
				.append(" ")
				.append(cartProduct.product.name)
				.append(" à ")
				.append(cartProduct.product.price.getPriceHT())
				.append(" : ")
				.append(cartProduct.price.getPriceTTC())
				.append("€");
			
			printLine(sb);
			sb.delete(0, sb.length());
		}
		
		printLine("");
		printLine("Montant des taxes : "+ cart.getTotalVAT() +"€");
		printLine("Total : "+ cart.getTotalTTC() +"€");
	}

}
