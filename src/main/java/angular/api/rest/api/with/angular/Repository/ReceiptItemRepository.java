package angular.api.rest.api.with.angular.Repository;

import angular.api.rest.api.with.angular.Model.ReceiptItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ReceiptItemRepository extends JpaRepository<ReceiptItem, Long> {
    @Query("select r from ReceiptItem  r where r.receipt.receiptId =:Id")
    public List<ReceiptItem> findAllByReceiptId(@Param("Id") Long id);
}
