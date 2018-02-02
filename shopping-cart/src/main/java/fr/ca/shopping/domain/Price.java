package fr.ca.shopping.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ca.commons.math.BigDecimalUtil;
import fr.ca.shopping.common.resources.MessageResources;

public class Price {
	private static final Logger LOGGER = LoggerFactory.getLogger(Price.class);
	private static final BigDecimal priceDivider = new BigDecimal(100);
	
	public BigDecimal vat; // VAT amount to apply

	private BigDecimal priceHT;
	private BigDecimal priceTTC;
	private BigDecimal priceVAT;


	public Price(Product product, double priceHT) {
		this.priceHT = new BigDecimal(Double.toString(priceHT));

		loadVAT(product);

		computeTaxes();
	}
	
	public Price(Product product, double priceHT, double priceTTC) {
		this.priceHT = new BigDecimal(Double.toString(priceHT));
		this.priceTTC = new BigDecimal(Double.toString(priceTTC));
		this.priceVAT = this.priceTTC.subtract(this.priceHT);
		
		loadVAT(product);
	}

	private void computeTaxes() {
		this.priceVAT = new BigDecimal(priceHT.toString()).multiply(vat).divide(priceDivider);
		this.priceTTC =  priceHT.add(priceVAT); 
	}

	private void loadVAT(Product product) {
		this.vat = new BigDecimal(MessageResources.PRICING.getString(product.type.toString()));

		if(product.imported) {
			this.vat = new BigDecimal(MessageResources.PRICING.getString("imported"));
		}
	}

	public BigDecimal getPriceHT() {
		return priceHT;
	}

	public BigDecimal getPriceTTC() {
		return BigDecimalUtil.round(priceTTC, "0.05", RoundingMode.UP);
	}

	public BigDecimal getPriceVAT() {
		return BigDecimalUtil.round(priceVAT, "0.05", RoundingMode.UP);
	}

	
}
