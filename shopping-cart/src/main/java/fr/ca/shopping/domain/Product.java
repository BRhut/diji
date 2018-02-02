package fr.ca.shopping.domain;

public class Product {
	public ProductType type;
	public String name;
	public boolean imported;
	public Price price;

	
	public Product(ProductType type, String name, double price, boolean imported) {
		super();
		this.type = type;
		this.name = name;
		this.imported = imported;
		this.price = new Price(this, price);
	}
	
	
}
