package WebThiTA.reponsitory;


import WebThiTA.model.BaiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiHocRepo extends JpaRepository<BaiHoc, Long> {


}
