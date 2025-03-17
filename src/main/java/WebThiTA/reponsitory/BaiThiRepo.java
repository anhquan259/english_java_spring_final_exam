package WebThiTA.reponsitory;


import WebThiTA.model.BaiThi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiThiRepo extends JpaRepository<BaiThi, Long> {

}