package angular.api.rest.api.with.angular.Repository;

import angular.api.rest.api.with.angular.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("select p from Product p where p.productStatus= true order by p.productId desc ")
    public List<Product> findAll();

    @Query("select p from Product p where p.productStatus= true and p.category.name like %:nameProduct% order by p.productId desc ")
    public List<Product> findAllByCategory(@Param("nameProduct") String name);

    @Query("select p from Product p where p.productStatus= true and p.category.categoryId =:Id order by p.productId desc ")
    public List<Product> findAllByCategoryId(@Param("Id") Long id);

    @Transactional
    @Modifying
    @Query("delete from Product p where p.category.categoryId =:Id")
    public int deleteAllByCategoryId(@Param("Id") Long id);
}
