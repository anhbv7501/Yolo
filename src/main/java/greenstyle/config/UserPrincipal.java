package greenstyle.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{

	private int userId;
	private String email;
	private String password;
	private String role;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	 @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

	        list.add(new SimpleGrantedAuthority(role));

	        return list;
	    }
	 @Override
	    public boolean isAccountNonExpired() {
	        return false;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return false;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return false;
	    }

	    @Override
	    public boolean isEnabled() {
	        return false;
	    }
		@Override
		public String getUsername() {
			return email;
		}
}
