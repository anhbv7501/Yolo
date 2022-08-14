package greenstyle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import greenstyle.dto.DataDTO;
import greenstyle.dto.DataResponse;
import greenstyle.dto.Message;
import greenstyle.dto.OneProduct;
import greenstyle.dto.ResProduct;
import greenstyle.dto.ResponseData;
import greenstyle.dto.ValueData;
import greenstyle.entity.Product;
import greenstyle.service.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/admin/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public ResponseData get(@RequestParam(name = "page",required = false) Integer page) {
		List<Product> list =  productService.getAll();
		List<Product> listData  = new ArrayList<Product>();
		List<ResProduct> listP =  new ArrayList<ResProduct>();
		for(Product p : list) {
			listP.add(new ResProduct(p));
		}
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		DataDTO valuesData  = new DataDTO();
		valuesData.setData(listP);
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	
	@GetMapping("/show")
	public ResponseData getAll(@RequestParam(name = "option",required = false) String option ) {
		List<Product> list =  productService.getAll();
		List<Product> listData  = new ArrayList<Product>();
		System.out.println(option);
		for(Product product : list) {
			System.out.println("product "+product.getLabel());
			if(option != null && product.getLabel().equals(option)) {			
				listData.add(product);
			}
		}
		List<ResProduct> listP =  new ArrayList<ResProduct>();
		for(Product p : list) {
			listP.add(new ResProduct(p));
		}
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		DataDTO valuesData  = new DataDTO();
		if(option != null) {
			valuesData.setData(listData);
		}else {
			valuesData.setData(listP);
		}
		
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	
	
	@GetMapping("/{id}")
	public ResponseData getOne(@PathVariable(name="id") int id) {
		ResProduct product =  productService.getOne(id);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		OneProduct data = new OneProduct();
		data.setProduct(product);
		response.setPayload(data);
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
