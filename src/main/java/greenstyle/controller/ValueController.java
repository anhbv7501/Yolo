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
import greenstyle.dto.CreateValueDTO;
import greenstyle.dto.Message;
import greenstyle.dto.ResponseData;
import greenstyle.dto.UpdateOptionDTO;
import greenstyle.dto.UpdateValueDTO;
import greenstyle.dto.ValueData;
import greenstyle.entity.Option;
import greenstyle.entity.OptionValue;
import greenstyle.service.OptionService;
import greenstyle.service.ValueService;

@RestController
@RequestMapping("/api/v1/admin/option-value")
public class ValueController {

	@Autowired
	private ValueService valueService;
	

	@GetMapping("/{id}")
	public ResponseData getOne(@PathVariable(name="id") int id) {
		OptionValue value =  valueService.getOne(id);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		ValueData valuesData  = new ValueData();
		valuesData.setMessage("");
		valuesData.setValues(value);
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	
	@PostMapping()
	public ResponseData create(@RequestBody CreateValueDTO data) {
		OptionValue value = valueService.create(data);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		ValueData valuesData  = new ValueData();
		valuesData.setMessage("Tao moi noi dung danh muc thanh cong");
		valuesData.setValues(value);
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseData update(@PathVariable(name="id") int id,@RequestBody UpdateValueDTO data) {
		OptionValue value = valueService.update(id,data);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		ValueData valuesData  = new ValueData();
		valuesData.setMessage("Tao moi noi dung danh muc thanh cong");
		valuesData.setValues(value);
		response.setPayload(valuesData);
		response.setError(null);
		return response;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseData delete(@PathVariable(name="id") int id){
		Boolean success = valueService.delete(id);
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
