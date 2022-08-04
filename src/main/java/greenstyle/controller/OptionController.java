package greenstyle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greenstyle.dto.CreateOptionDTO;
import greenstyle.dto.CreateProductDTO;
import greenstyle.dto.Message;
import greenstyle.dto.ResponseData;
import greenstyle.dto.UpdateOptionDTO;
import greenstyle.entity.Option;
import greenstyle.entity.Product;
import greenstyle.service.OptionService;

@RestController
@RequestMapping("/api/v1/admin/option")
public class OptionController {

	@Autowired
	private OptionService optionService;
	
	@GetMapping()
	public ResponseData getAll() {
		
		List<Option> option =  optionService.getAll();
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		response.setPayload(option);
		response.setError(null);
		return response;
	}
	@GetMapping("/{id}")
	public ResponseData getOne(@PathVariable(name="id") int id) {
		Option option =  optionService.getOne(id);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		response.setPayload(option);
		response.setError(null);
		return response;
	}
	
	@PostMapping()
	public ResponseData create(@RequestBody CreateOptionDTO data) {
		optionService.create(data);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		Message mes  = new Message();
		mes.setMessage("Tao moi danh muc thanh cong");
		response.setPayload(mes);
		response.setError(null);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseData update(@PathVariable(name="id") int id,@RequestBody UpdateOptionDTO data) {
		optionService.update(id,data);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		Message mes  = new Message();
		mes.setMessage("Tao moi danh muc thanh cong");
		response.setPayload(mes);
		response.setError(null);
		return response;
		
	}
	@DeleteMapping("/{id}")
	public ResponseData delete(@PathVariable(name="id") int id){
		Boolean success = optionService.delete(id);
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
