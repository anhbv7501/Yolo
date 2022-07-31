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
import greenstyle.dto.UpdateOptionDTO;
import greenstyle.entity.Option;
import greenstyle.entity.Product;
import greenstyle.service.OptionService;

@RestController
@RequestMapping("/api/option")
public class OptionController {

	@Autowired
	private OptionService optionService;
	
	@GetMapping()
	public List<Option> getAll() {
		return optionService.getAll();
	}
	@GetMapping("/{id}")
	public Option getOne(@PathVariable(name="id") int id) {
		return optionService.getOne(id);
	}
	
	@PostMapping("/create")
	public Option create(@RequestBody CreateOptionDTO data) {
		return optionService.create(data);
	}
	
	@PutMapping("/update/{id}")
	public Option update(@PathVariable(name="id") int id,@RequestBody UpdateOptionDTO data) {
		return optionService.update(id,data);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") int id){
		Boolean success = optionService.delete(id);
		if(!success) {
			return "Xoa that bai";
		}
		return "Xoa thanh cong";
	}
}
