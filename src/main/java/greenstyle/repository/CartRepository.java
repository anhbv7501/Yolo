package greenstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import greenstyle.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
