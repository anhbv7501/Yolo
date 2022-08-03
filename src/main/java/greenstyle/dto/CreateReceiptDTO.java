package greenstyle.dto;

import java.util.List;

public class CreateReceiptDTO {

	private String description;
	private String address;
	private String method;
	private List<ProductI>  products;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<ProductI> getProducts() {
		return products;
	}
	public void setProducts(List<ProductI> products) {
		this.products = products;
	}
	
	
	
}
