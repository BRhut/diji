package fr.ca.shopping.services.invoice;

import java.io.File;

import fr.ca.shopping.domain.Cart;

public interface IPrintInvoice {

	File print(Cart cart) throws Exception;

}