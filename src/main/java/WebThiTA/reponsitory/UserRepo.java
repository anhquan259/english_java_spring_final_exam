package WebThiTA.reponsitory;


import WebThiTA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username = ?1")
    Optional<User> findByUsername(String username);

    @Query("select u from User u where u.role = 1"
            + "order by u.diemTB desc , " + "SUBSTRING(u.Fullname, LOCATE(' ', u.Fullname) + 1) asc")
    List<User> findAllWithRole1Sorted();

    User saveAndFlush(User user);
}
