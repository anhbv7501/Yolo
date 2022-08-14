package greenstyle.dto;

import greenstyle.entity.User;

public class LoginResponse {

	private ResUserDTO user;
	private String token;
	
	
	public ResUserDTO getUser() {
		return user;
	}
	public void setUser(ResUserDTO user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
