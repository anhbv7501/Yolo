package greenstyle.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class Token {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tokenId;
	
	@Column(length = 1000)
	private String token;
	@Column()
	private Date tokenExpDate;
	
	public int getTokenId() {
		return tokenId;
	}
	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getTokenExpDate() {
		return tokenExpDate;
	}
	public void setTokenExpDate(Date tokenExpDate) {
		this.tokenExpDate = tokenExpDate;
	}
	
	
}
