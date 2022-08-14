package greenstyle.dto;

import java.util.ArrayList;
import java.util.List;

import greenstyle.entity.Product;
import greenstyle.entity.ProductImage;
import greenstyle.entity.ProductOption;


public class ResProduct {

	private int id;
	private String product_code;
	private String name;
	private String description;
	private String status;
	private String label;
	private List<ProductImagesDTO> images;
	private List<ResProductOption> product_options;
	
	public ResProduct(Product product) {
		this.id = product.getProductId();
		this.product_code =product.getProduct_code();
		this.name = product.getName();
		this.description = product.getDescription();
		this.status = product.getStatus();
		this.label = product.getLabel();
		List<ProductImagesDTO> listImage = new ArrayList<ProductImagesDTO>();
		for(ProductImage i : product.getImages()) {
			listImage.add(new ProductImagesDTO(i));
		}
		this.images = listImage;
		List<ResProductOption> listOp = new ArrayList<ResProductOption>();
		for(ProductOption i : product.getProduct_options()) {
			listOp.add(new ResProductOption(i));
		}
		this.product_options = listOp;
	}
	
	public ResProduct() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public List<ProductImagesDTO> getImages() {
		return images;
	}

	public void setImages(List<ProductImagesDTO> images) {
		this.images = images;
	}

	public List<ResProductOption> getProduct_options() {
		return product_options;
	}

	public void setProduct_options(List<ResProductOption> product_options) {
		this.product_options = product_options;
	}
	
	
	
	
	
}
