package greenstyle.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import greenstyle.dto.CreateValueDTO;
import greenstyle.dto.UpdateValueDTO;
import greenstyle.entity.Option;
import greenstyle.entity.OptionValue;
import greenstyle.repository.OptionRepository;
import greenstyle.repository.OptionValueRepository;

@Component
public class ValueService {

	@Autowired
	private OptionValueRepository opValueRepo;
	@Autowired
	private OptionRepository optionRepo;

	public OptionValue getOne(int id) {
		Optional<OptionValue> op = this.opValueRepo.findById(id);
		OptionValue optionValue = new OptionValue();
		if(op.isPresent()) {
			optionValue = op.get();
		}
		return optionValue;
	}
	
	public OptionValue create(CreateValueDTO data) {
		OptionValue optionV = new OptionValue();
		optionV.setName(data.getName());
		optionV.setValue_code(data.getName());
		Optional<Option> op  = Optional.ofNullable(new Option());
		if(data.getOptionId() > 0) {			
			op = this.optionRepo.findById(data.getOptionId());
		}
		Option option = new Option();
		if(op.isPresent()) {
			option = op.get();
		}
		option.setOptionId(data.getOptionId());
		optionV.setOption(option);
		this.opValueRepo.save(optionV);
		return optionV;
	}
	
	public OptionValue update(int id, UpdateValueDTO data) {
		Optional<OptionValue> op = this.opValueRepo.findById(id);
		OptionValue optionValue = new OptionValue();
		if(op.isPresent()) {
			optionValue = op.get();
		}
		optionValue.setName(data.getName());
		optionValue.setValue_code(data.getName());
		Option option = new Option();
		option.setOptionId(data.getOptionId());
		optionValue.setOption(option);
		this.opValueRepo.save(optionValue);
		return optionValue;
	}
	
	public Boolean delete(int id) {
		Optional<OptionValue> op = this.opValueRepo.findById(id);
		OptionValue value = new OptionValue();
		if(op.isPresent()) {
			value = op.get();
		}
		try{
			this.opValueRepo.delete(value);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
}
