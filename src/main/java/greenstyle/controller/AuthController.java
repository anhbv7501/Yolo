package greenstyle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greenstyle.config.JwtUtil;
import greenstyle.config.UserPrincipal;
import greenstyle.dto.UserDTO;
import greenstyle.entity.Token;
import greenstyle.entity.User;
import greenstyle.service.TokenService;
import greenstyle.service.UserService;

@RestController
@RequestMapping("/api/user")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@Autowired
	private TokenService tokenService;
	
	@GetMapping("/hello")
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	public ResponseEntity hello(){
	    return ResponseEntity.ok("hello");
	}
	@PostMapping("/register")
	public User register(@RequestBody UserDTO user) {
		User newUser = new User();
		newUser.setEmail(user.getUsername());
		newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userService.createUser(newUser);
	}
	
	 @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody UserDTO user){
	        UserPrincipal userPrincipal = userService.findByUsername(user.getUsername());
	        if (null == user || !new BCryptPasswordEncoder().matches(user.getPassword(), userPrincipal.getPassword())) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("tài khoản hoặc mật khẩu không chính xác");
	        }
	        Token token = new Token();
	        token.setToken(jwtUtil.generateToken(userPrincipal));
	        token.setTokenExpDate(jwtUtil.generateExpirationDate());
	        tokenService.createToken(token);
	        return ResponseEntity.ok(token.getToken());
	    }
	
	
}
