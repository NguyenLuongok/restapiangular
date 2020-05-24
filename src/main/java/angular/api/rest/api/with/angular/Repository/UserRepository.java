package angular.api.rest.api.with.angular.Repository;

import angular.api.rest.api.with.angular.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u order by u.userId desc ")
    public List<User> findAll();

    @Query("select u from User u where u.email =:e")
    public User findByEmail(@Param("e")String email);

    @Query("select u from User u where u.email =:e and u.password =:pass")
    public User checkLogin(@Param("e") String email, @Param("pass") String pass);
}
