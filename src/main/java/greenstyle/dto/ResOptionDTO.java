package greenstyle.dto;

import java.util.ArrayList;
import java.util.List;

import greenstyle.entity.Option;
import greenstyle.entity.OptionValue;

public class ResOptionDTO {

	private int id;
	private String name;
	private String option_code;
	private String type;
	private List<ValueDTO> values;
	
	public ResOptionDTO(Option data) {
		this.id = data.getOptionId();
		this.name = data.getName();
		this.option_code = data.getOption_code();
		this.type = data.getType();
		List<ValueDTO> list = new ArrayList<ValueDTO>();
		for(OptionValue op : data.getValues()) {
			list.add(new ValueDTO(op));
		}
		this.values = list;
	}
	
	public ResOptionDTO() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOption_code() {
		return option_code;
	}
	public void setOption_code(String option_code) {
		this.option_code = option_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public List<ValueDTO> getValues() {
		return values;
	}

	public void setValues(List<ValueDTO> values) {
		this.values = values;
	}

	
	
}
