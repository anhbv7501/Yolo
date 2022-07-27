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
@Table(name="product_option")
public class ProductOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productOptionId;
	
	@Column()
	private Double price;
	
	@Column()
	private int number;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId")
	@JsonIgnoreProperties(value = "product_options")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "optionId")
	@JsonIgnoreProperties(value = "product_options")
	private Option option;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "optionValueId")
	@JsonIgnoreProperties(value = "product_options")
	private OptionValue value;
	
	@OneToMany(mappedBy = "product_option")
	@JsonIgnoreProperties(value = "product_option")
	private List<CartProduct> cart_products;
	
	@OneToMany(mappedBy = "receipt_product")
	@JsonIgnoreProperties(value = "receipt_product")
	private List<ReceiptProductOption> receipt_product_options;

	public int getProductOptionId() {
		return productOptionId;
	}

	public void setProductOptionId(int productOptionId) {
		this.productOptionId = productOptionId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public OptionValue getValue() {
		return value;
	}

	public void setValue(OptionValue value) {
		this.value = value;
	}

	public List<CartProduct> getCart_products() {
		return cart_products;
	}

	public void setCart_products(List<CartProduct> cart_products) {
		this.cart_products = cart_products;
	}

	public List<ReceiptProductOption> getReceipt_product_options() {
		return receipt_product_options;
	}

	public void setReceipt_product_options(List<ReceiptProductOption> receipt_product_options) {
		this.receipt_product_options = receipt_product_options;
	}
	
	
	
}
