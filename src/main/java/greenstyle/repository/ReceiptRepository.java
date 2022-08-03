package greenstyle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import greenstyle.entity.Receipt;
import greenstyle.entity.User;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer>{

	@Query("SELECT r FROM Receipt r WHERE r.user.userId = :id")
	List<Receipt> findByUser(@Param("id")Integer id);
}
