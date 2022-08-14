package greenstyle.dto;

import greenstyle.entity.Option;

public class OptionDTO {

	private int id;
	private String name;
	private String option_code;
	private String type;
	
	public OptionDTO(Option data) {
		this.id = data.getOptionId();
		this.name = data.getName();
		this.option_code = data.getOption_code();
		this.type = data.getType();
	}
	
	public OptionDTO() {
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
	
	
	
}
