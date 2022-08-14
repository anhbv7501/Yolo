package greenstyle.dto;

import greenstyle.entity.ProductImage;

public class ProductImagesDTO {

	private int id;
	private String path;
	private String fullpath;
	
	public ProductImagesDTO(ProductImage data) {
		this.id = data.getProductImageId();
		this.path = data.getPath();
		this.fullpath = data.getFullpath();
	}
	
	public ProductImagesDTO() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFullpath() {
		return fullpath;
	}
	public void setFullpath(String fullpath) {
		this.fullpath = fullpath;
	}
	
	
}
