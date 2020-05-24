package angular.api.rest.api.with.angular.Repository;

import angular.api.rest.api.with.angular.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("select c from Category c where c.name =:nameCategory order by c.categoryId desc")
    public Category findByName(@Param("nameCategory") String name);
}
