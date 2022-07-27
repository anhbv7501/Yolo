package greenstyle.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="option_values")
public class OptionValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int optionValueId;
	
	@Column()
	private String value_code;
	
	@Column()
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "optionId")
	@JsonIgnoreProperties(value = "values")
	private Option option;
	
	@OneToMany(mappedBy = "value")
	@JsonIgnoreProperties(value = "value")
	private List<ProductOption> product_options;

	public int getOptionValueId() {
		return optionValueId;
	}

	public void setOptionValueId(int optionValueId) {
		this.optionValueId = optionValueId;
	}

	public String getValue_code() {
		return value_code;
	}

	public void setValue_code(String value_code) {
		this.value_code = value_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public List<ProductOption> getProduct_options() {
		return product_options;
	}

	public void setProduct_options(List<ProductOption> product_options) {
		this.product_options = product_options;
	}
	
	
}
