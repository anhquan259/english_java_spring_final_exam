package WebThiTA.reponsitory;


import WebThiTA.dto.DiemDTO;
import WebThiTA.model.Diem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiemRepo extends JpaRepository<Diem, Long> {
    @Query("select d from Diem d where d.user.username = ?1 and d.exam.examId= ?2")
    Optional<Diem> find2(String username, Long examId);

    @Query("select d from Diem d where d.user.username = ?1")
    List<Diem> findByUsername(String username);

    @Query("select u.Fullname as fullName, " +
            "ex.examName as examName," +
            "d.testDay as dateTest," +
            "d.point as point " +
            "from Diem d " +
            "inner join " +
            "User u on d.user.userId = u.userId " +
            "inner join BaiThi ex on d.exam.examId = ex.examId " +
            "where d.user.userId = ?1 order by dateTest desc ")
    List<DiemDTO> findByUserId(Long userId);
}
