package greenstyle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import greenstyle.entity.Token;
import greenstyle.repository.TokenRepository;

@Component
public class TokenService {

	@Autowired
	private TokenRepository tokenRepo;
	
	public Token createToken(Token token) {
		return tokenRepo.save(token);
	}
	
	public Token findByToken(String token) {
	    return tokenRepo.findByToken(token);
	}
}
