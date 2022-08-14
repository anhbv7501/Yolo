package greenstyle.dto;

import greenstyle.entity.OptionValue;

public class ValueDTO {

	private int id;
	private String name;
	private String value_code;
	
	public ValueDTO(OptionValue data) {
		this.id = data.getOptionValueId();
		this.name = data.getName();
		this.value_code = data.getValue_code();
	}
	
	
	public ValueDTO() {
		
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
	public String getValue_code() {
		return value_code;
	}
	public void setValue_code(String value_code) {
		this.value_code = value_code;
	}
	
	
}
