package greenstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import greenstyle.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
