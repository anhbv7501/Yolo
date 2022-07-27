package greenstyle.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="receipt_products")
public class ReceiptProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int receiptProductId;
	
	@Column()
	private int quantity;
	
	@Column()
	private Double unit_price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiptId")
	@JsonIgnoreProperties(value = "receipt_products")
	private Receipt receipt;
	
	@OneToMany(mappedBy = "receipt_product")
	@JsonIgnoreProperties(value = "receipt_product")
	private List<ReceiptProductOption> receipt_product_options;

	public int getReceiptProductId() {
		return receiptProductId;
	}

	public void setReceiptProductId(int receiptProductId) {
		this.receiptProductId = receiptProductId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public List<ReceiptProductOption> getReceipt_product_options() {
		return receipt_product_options;
	}

	public void setReceipt_product_options(List<ReceiptProductOption> receipt_product_options) {
		this.receipt_product_options = receipt_product_options;
	}
	
	
}
