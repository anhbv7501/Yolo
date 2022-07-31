package greenstyle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import greenstyle.dto.CreateOptionDTO;
import greenstyle.dto.UpdateOptionDTO;
import greenstyle.entity.Option;
import greenstyle.repository.OptionRepository;

@Component
public class OptionService {

	@Autowired
	private OptionRepository optionRepo;
	
	public List<Option> getAll(){
		return this.optionRepo.findAll();
	}
	
	public Option getOne(int id) {
		Optional<Option> op = this.optionRepo.findById(id);
		Option option = new Option();
		if(op.isPresent()) {
			option = op.get();
		}
		return option;
	}
	
	public Option create(CreateOptionDTO data) {
		Option option = new Option();
		option.setName(data.getName());
		option.setType(data.getMeta());
		option.setOption_code(data.getName());
		this.optionRepo.save(option);
		return option;
	}
	
	public Option update(int id ,UpdateOptionDTO data) {
		Optional<Option> op = this.optionRepo.findById(id);
		Option option = new Option();
		if(op.isPresent()) {
			option = op.get();
		}
		option.setName(data.getName());
		option.setType(data.getMeta());
		option.setOption_code(data.getName());
		this.optionRepo.save(option);
		return option;
	}
 	

	public Boolean delete(int id) {
		Optional<Option> op = this.optionRepo.findById(id);
		Option option = new Option();
		if(op.isPresent()) {
			option = op.get();
		}
		try{
			this.optionRepo.delete(option);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	
}
