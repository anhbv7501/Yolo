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
import greenstyle.dto.Message;
import greenstyle.dto.ResponseData;
import greenstyle.dto.ValueData;
import greenstyle.entity.Product;
import greenstyle.service.ProductService;

@RestController
@RequestMapping("/api/v1/admin/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/show")
	public ResponseData getAll() {
		List<Product> list =  productService.getAll();
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		ValueData valuesData  = new ValueData();
		valuesData.setMessage("");
		valuesData.setValues(list);
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	@GetMapping("/{id}")
	public ResponseData getOne(@PathVariable(name="id") int id) {
		Product product =  productService.getOne(id);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		ValueData valuesData  = new ValueData();
		valuesData.setMessage("");
		valuesData.setValues(product);
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	
	@PostMapping()
	public ResponseData create(@RequestBody CreateProductDTO data) {
		Product product =   productService.create(data);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		ValueData valuesData  = new ValueData();
		valuesData.setMessage("Tao moi san pham thanh cong");
		valuesData.setValues(product);
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	@DeleteMapping("/{id}")
	public ResponseData delete(@PathVariable(name="id") int id){
		Boolean success = productService.delete(id);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		
		if(!success) {
			Message mes  = new Message();
			mes.setMessage("Xoa thanh cong");
			response.setPayload(mes);
			response.setError(null);
		}else {
			response.setPayload(null);
			response.setError("Xoa that bai");
		}
		return response;
	}
}
