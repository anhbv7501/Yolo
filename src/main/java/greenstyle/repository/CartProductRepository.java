package greenstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import greenstyle.entity.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer>{

}
