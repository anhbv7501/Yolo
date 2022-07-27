package greenstyle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import greenstyle.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer>{

}
