package greenstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import greenstyle.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
