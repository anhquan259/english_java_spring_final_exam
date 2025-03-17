package WebThiTA.reponsitory;


import WebThiTA.model.CauHoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CauHoiRepo extends JpaRepository<CauHoi, Long> {

    @Query("select ch from CauHoi ch where ch.exam.examId = ?1")
    List<CauHoi> findByExam(Long examId);

}
