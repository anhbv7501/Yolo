package greenstyle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="receipt_product_product_option")
public class ReceiptProductOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int receiptProductOptionId;
	
	@Column()
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiptProductId")
	@JsonIgnoreProperties(value = "receipt_product_options")
	private ReceiptProduct receipt_product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productOptionId")
	@JsonIgnoreProperties(value = "receipt_product_options")
	private ProductOption product_option;

	public int getReceiptProductOptionId() {
		return receiptProductOptionId;
	}

	public void setReceiptProductOptionId(int receiptProductOptionId) {
		this.receiptProductOptionId = receiptProductOptionId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ReceiptProduct getReceipt_product() {
		return receipt_product;
	}

	public void setReceipt_product(ReceiptProduct receipt_product) {
		this.receipt_product = receipt_product;
	}

	public ProductOption getProduct_option() {
		return product_option;
	}

	public void setProduct_option(ProductOption product_option) {
		this.product_option = product_option;
	}
	
	
}
