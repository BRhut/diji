package fr.ca.shopping.common.resources;

import java.math.BigDecimal;
import java.util.ResourceBundle;

public class MessageResources {
	public static final ResourceBundle PRICING = ResourceBundle.getBundle("fr.ca.shopping.common.resources.pricing");
	
	public static BigDecimal getBigDecimal(ResourceBundle bundle, String key) {
		return new BigDecimal(bundle.getString(key));
	}
	
	public static double getDouble(ResourceBundle bundle, String key) {
		return Double.valueOf(bundle.getString(key));
	}
}
