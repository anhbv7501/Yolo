package greenstyle.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import greenstyle.entity.Cart;
import greenstyle.entity.Receipt;
import greenstyle.entity.Role;
import greenstyle.entity.User;

public class ResUserDTO {


	private int id;
	private String user_code;
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	private String address;
	private String gender;
	private String avatar;
	private String phone;
	private String id_card;
	private String status;	
	private Date date_of_birth;
	private List<ResReceiptDTO> receipts;
	
	public ResUserDTO(User data) {
		this.id = data.getUserId();
		this.user_code = data.getUser_code();
		this.email = data.getEmail();
		this.first_name = data.getFirst_name();
		this.last_name = data.getLast_name();
		this.address = data.getAddress();
		this.gender = data.getGender();
		this.avatar = data.getAvatar();
		this.phone = data.getPhone();
		this.id_card = data.getId_card();
		this.status = data.getStatus();
		this.date_of_birth = data.getDate_of_birth();
		List<ResReceiptDTO> list = new ArrayList<ResReceiptDTO>();
		if(data.getReceipts().size() > 0) {
			for(Receipt receipt : data.getReceipts()) {
				list.add(new ResReceiptDTO(receipt));
			}
		}
		this.receipts = list;
	}
	
	
	public ResUserDTO() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public List<ResReceiptDTO> getReceipts() {
		return receipts;
	}
	public void setReceipts(List<ResReceiptDTO> receipts) {
		this.receipts = receipts;
	}
	
	
	
	
	
	
}
