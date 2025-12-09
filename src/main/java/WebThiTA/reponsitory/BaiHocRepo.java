package WebThiTA.reponsitory;


import WebThiTA.model.BaiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaiHocRepo extends JpaRepository<BaiHoc, Long> {
    @Query("SELECT bh FROM BaiHoc bh " +
            "JOIN FETCH bh.level " +
            "JOIN FETCH bh.lesson")
    List<BaiHoc> findAllWithLevelAndLesson();

}
