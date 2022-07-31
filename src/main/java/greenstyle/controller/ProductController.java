package greenstyle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import greenstyle.dto.CreateProductDTO;
import greenstyle.entity.Product;
import greenstyle.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/show")
	public List<Product> getAll() {
		return productService.getAll();
	}
	@GetMapping("/{id}")
	public Product getOne(@PathVariable(name="id") int id) {
		return productService.getOne(id);
	}
	
	@PostMapping("/create")
	public Product create(@RequestBody CreateProductDTO data) {
		return productService.create(data);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") int id){
		Boolean success = productService.delete(id);
		if(!success) {
			return "Xoa that bai";
		}
		return "Xoa thanh cong";
	}
}
