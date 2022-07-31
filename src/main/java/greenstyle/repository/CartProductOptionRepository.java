package greenstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import greenstyle.entity.CartProductOption;

public interface CartProductOptionRepository extends JpaRepository<CartProductOption, Integer>{

}
