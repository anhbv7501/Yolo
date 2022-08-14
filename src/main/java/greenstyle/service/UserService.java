package greenstyle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import greenstyle.config.UserPrincipal;
import greenstyle.dto.ChangeStatusDTO;
import greenstyle.entity.Product;
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
	public User findUser(String username) {
		User user = userRepo.findByUsername(username);        
        return user;
	}
	
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	public User changeStatus(int id,ChangeStatusDTO data) {
		Optional<User> op = this.userRepo.findById(id);
		User user = new User();
		if(op.isPresent()) {
			user = op.get();
			user.setStatus(data.getStatus());
			this.userRepo.save(user);
		}
		return user;
	}
	
	
	
}

