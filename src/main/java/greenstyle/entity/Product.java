package greenstyle.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column
	private String product_code;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column()
	private String status;
	
	@Column()
	private String label;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnoreProperties(value = "product")
	private List<ProductImage> images;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnoreProperties(value = "product")
	private List<ProductOption> product_options;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<ProductImage> getImages() {
		return images;
	}

	public void setImages(List<ProductImage> images) {
		this.images = images;
	}

	public List<ProductOption> getProduct_options() {
		return product_options;
	}

	public void setProduct_options(List<ProductOption> product_options) {
		this.product_options = product_options;
	}
	

	
	
}
