package greenstyle.dto;

import greenstyle.entity.ProductOption;

public class ResProductOption {

	private int id;
	private int number;
	private double price;
	private OptionDTO option;
	private ValueDTO value;
	
	public ResProductOption(ProductOption data) {
		this.id = data.getProductOptionId();
		this.number = data.getNumber();
		this.price = data.getPrice();
		OptionDTO op  = new OptionDTO(data.getOption());
		this.option = op;
		ValueDTO vl  = new ValueDTO(data.getValue()); 
		this.value = vl;
	}
	
	
	public ResProductOption() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public OptionDTO getOption() {
		return option;
	}
	public void setOption(OptionDTO option) {
		this.option = option;
	}
	public ValueDTO getValue() {
		return value;
	}
	public void setValue(ValueDTO value) {
		this.value = value;
	}
	
	
}
