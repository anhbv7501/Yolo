package greenstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import greenstyle.entity.Token;
import greenstyle.entity.User;

public interface TokenRepository extends JpaRepository<Token, Integer>{

	@Query("SELECT t FROM Token t WHERE t.token = :token")
	Token findByToken(@Param("token")String token);
}
