package greenstyle.dto;

import java.util.List;

public class ProductI {

	private List<Integer> productOptionId;
	private int quantity;
	private double price;
	public List<Integer> getProductOptionId() {
		return productOptionId;
	}
	public void setProductOptionId(List<Integer> productOptionId) {
		this.productOptionId = productOptionId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
