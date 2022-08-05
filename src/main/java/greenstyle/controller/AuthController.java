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
import greenstyle.dto.LoginDTO;
import greenstyle.dto.Message;
import greenstyle.dto.ResponseData;
import greenstyle.dto.UserDTO;
import greenstyle.dto.ValueData;
import greenstyle.entity.Token;
import greenstyle.entity.User;
import greenstyle.service.TokenService;
import greenstyle.service.UserService;

@RestController
@RequestMapping("/api/v1")
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
	
	@PostMapping("/user/auth/register")
	public ResponseData register(@RequestBody UserDTO user) {
		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		newUser.setAddress(user.getAddress());
		newUser.setFirst_name(user.getFirst_name());
		newUser.setLast_name(user.getLast_name());
		newUser.setGender(user.getGender());
		newUser.setPhone(user.getPhone());
		newUser.setId_card(user.getId_card());
		newUser.setDate_of_birth(user.getDate_of_birth());
		userService.createUser(newUser);
		ResponseData response = new ResponseData();
		response.setSuccess(true);
		Message mes  = new Message();
		mes.setMessage("Tao moi nguoi dung thanh cong");
		response.setPayload(mes);
		response.setError(null);
		return response;
	}
	
	 @PostMapping("/user/auth/login")
	    public ResponseEntity<?> login(@RequestBody LoginDTO user){
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
