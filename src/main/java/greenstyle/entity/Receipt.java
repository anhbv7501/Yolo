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
@Table(name="receipts")
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int receiptId;
	
	@Column()
	private String receipt_code;
	
	@Column()
	private String description;
	
	@Column()
	private String address;
	
	@Column()
	private String method;
	
	@Column()
	private Double total_price;
	
	@Column()
	private String status;
	
	@ManyToOne()
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties(value = "receipts")
	private User user;
	
	@OneToMany(mappedBy = "receipt")
	@JsonIgnoreProperties(value = "receipt")
	private List<ReceiptProduct> receipt_products;

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public String getReceipt_code() {
		return receipt_code;
	}

	public void setReceipt_code(String receipt_code) {
		this.receipt_code = receipt_code;
	}

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

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ReceiptProduct> getReceipt_products() {
		return receipt_products;
	}

	public void setReceipt_products(List<ReceiptProduct> receipt_products) {
		this.receipt_products = receipt_products;
	}
	
	
	
}
