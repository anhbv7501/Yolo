package greenstyle.dto;

import greenstyle.entity.Receipt;

public class ResReceiptDTO {

	private int id;
	private String address;
	private String 	description;
	private String method;
	private String receipt_code;
	private String status;
	private Double total_price;
	
	public ResReceiptDTO(Receipt data) {
		this.id = data.getId();
		this.address = data.getAddress();
		this.description = data.getDescription();
		this.method = data.getMethod();
		this.receipt_code = data.getReceipt_code();
		this.status = data.getStatus();
		this.total_price = data.getTotal_price();
	}
	
	
	public ResReceiptDTO() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getReceipt_code() {
		return receipt_code;
	}
	public void setReceipt_code(String receipt_code) {
		this.receipt_code = receipt_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	
	
}
