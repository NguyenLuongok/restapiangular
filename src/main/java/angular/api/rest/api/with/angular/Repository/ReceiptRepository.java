package angular.api.rest.api.with.angular.Repository;

import angular.api.rest.api.with.angular.Model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ReceiptRepository extends JpaRepository<Receipt,Long> {

    @Query("select r from Receipt r order by r.receiptId desc ")
    List<Receipt> findAll();

    @Query("select r from Receipt r where r.user.userId =:Id order by r.receiptId desc ")
    List<Receipt> findAllByUserId(@Param("Id") Long id);

    @Query("select r from Receipt r where r.codeOrders =:name")
    Receipt findByCodeOrders(@Param("name") String name);
}
