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
import greenstyle.dto.UpdateOptionDTO;
import greenstyle.dto.UpdateValueDTO;
import greenstyle.entity.Option;
import greenstyle.entity.OptionValue;
import greenstyle.service.OptionService;
import greenstyle.service.ValueService;

@RestController
@RequestMapping("/api/option-value")
public class ValueController {

	@Autowired
	private ValueService valueService;
	

	@GetMapping("/{id}")
	public OptionValue getOne(@PathVariable(name="id") int id) {
		return valueService.getOne(id);
	}
	
	@PostMapping("/create")
	public OptionValue create(@RequestBody CreateValueDTO data) {
		return valueService.create(data);
	}
	
	@PutMapping("/update/{id}")
	public OptionValue update(@PathVariable(name="id") int id,@RequestBody UpdateValueDTO data) {
		return valueService.update(id,data);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") int id){
		Boolean success = valueService.delete(id);
		if(!success) {
			return "Xoa that bai";
		}
		return "Xoa thanh cong";
	}
}
