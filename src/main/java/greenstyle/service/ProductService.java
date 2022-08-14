package greenstyle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import greenstyle.dto.CreateProductDTO;
import greenstyle.dto.ProductOptionDTO;
import greenstyle.dto.ResProduct;
import greenstyle.entity.Product;
import greenstyle.entity.ProductImage;
import greenstyle.entity.ProductOption;
import greenstyle.repository.ProductImageRepository;
import greenstyle.repository.ProductOptionRepository;
import greenstyle.repository.ProductRepository;
import java.util.Optional;

@Component
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductOptionRepository productOpRepo;
	@Autowired
	private ProductImageRepository productImRepo;
	
	public Product asignProduct(CreateProductDTO data) {
		Gson gson = new Gson();
		ProductOptionDTO[] po = gson.fromJson(data.getOptions(),ProductOptionDTO[].class );
		String[] pi = gson.fromJson(data.getImages(), String[].class);
		Product product = new Product();
		product.setName(data.getName());
		product.setDescription(data.getDescription());
		product.setLabel(data.getLabel());
		product.setProduct_code(data.getName());
		product.setStatus(data.getStatus());
		List<ProductOption> listPo = new ArrayList<ProductOption>();
		for(ProductOptionDTO p : po) {
			ProductOption newPo  = new ProductOption();
			newPo.setNumber(data.getNumber());
			newPo.setPrice(p.getPrice());
			listPo.add(newPo);
		}
		List<ProductImage> listPi = new ArrayList<ProductImage>();
		for(String p : pi) {
			ProductImage newImg = new ProductImage();
			newImg.setPath(p);
			newImg.setFullpath(p);
			listPi.add(newImg);
		}
		product.setProduct_options(listPo);
		product.setImages(listPi);
		return product;
	}
	
	public List<Product> getAll(){
		return this.productRepo.findAll();	
	}
	
	public ResProduct getOne(int id) {
		Optional<Product> op = this.productRepo.findById(id);
		Product product = new Product();
		if(op.isPresent()) {
			System.out.println(op.get().getName());
			ResProduct res = new ResProduct(op.get());
			return res;
		}
		ResProduct res = new ResProduct(product);
		return res;
	}
	
	public Product create(CreateProductDTO data) {
		Product product = asignProduct(data);
		this.productRepo.save(product);
		for(ProductOption p : product.getProduct_options()) {
			p.setProduct(product);
			this.productOpRepo.save(p);
		}
		for(ProductImage p : product.getImages()) {
			p.setProduct(product);
			this.productImRepo.save(p);
		}
		return product;
	}


	public Boolean delete(int id) {
		Optional<Product> op = this.productRepo.findById(id);
		Product product = new Product();
		if(op.isPresent()) {
			product = op.get();
		}
		List<ProductOption> listPo = product.getProduct_options();
		List<ProductImage> listIm = product.getImages();
		try{
			
			for(ProductOption p : listPo ) {
				this.productOpRepo.delete(p);
			}
			for(ProductImage p : listIm) {
				this.productImRepo.delete(p);
			}
			this.productRepo.delete(product);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	
	
}
