package greenstyle.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="options")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int optionId;
	
	@Column()
	private String option_code;
	
	@Column()
	private String name;
	
	@Column()
	private String type;
	
	@OneToMany(mappedBy = "option")
	@JsonIgnoreProperties(value = "option")
	private List<OptionValue> values;
	
	@OneToMany(mappedBy = "option")
	@JsonIgnoreProperties(value = "option")
	private List<ProductOption> product_options;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getOption_code() {
		return option_code;
	}

	public void setOption_code(String option_code) {
		this.option_code = option_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<OptionValue> getValues() {
		return values;
	}

	public void setValues(List<OptionValue> values) {
		this.values = values;
	}

	public List<ProductOption> getProduct_options() {
		return product_options;
	}

	public void setProduct_options(List<ProductOption> product_options) {
		this.product_options = product_options;
	}
	
	
	
}
