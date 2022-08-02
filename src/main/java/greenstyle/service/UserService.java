package greenstyle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import greenstyle.config.UserPrincipal;
import greenstyle.entity.User;
import greenstyle.repository.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public UserPrincipal findByUsername(String username) {
		User user = userRepo.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal();
        
        if(null != user) {
        	
        	userPrincipal.setUserId(user.getUserId());
        	userPrincipal.setEmail(user.getEmail());
        	userPrincipal.setPassword(user.getPassword());
        	userPrincipal.setRole(user.getRole().getName());
        }
        return userPrincipal;
	}
}
