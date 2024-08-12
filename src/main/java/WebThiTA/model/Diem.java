package WebThiTA.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "diem")
@Data
public class Diem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    @EqualsAndHashCode.Include
    private Long pointId;
	@Column(nullable = false)
	private String testDay;
    @Column(nullable = false)
    private Double point;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="exam_id", nullable = false, referencedColumnName = "exam_id")
	@JsonBackReference
    @ToString.Exclude
	private BaiThi exam;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false, referencedColumnName = "user_id")
    @JsonBackReference
    @ToString.Exclude
    private User user;

    public Diem() {
        super();
    }

    public Double getPoint() {
        return point;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }


    public String getTestDay() {
        return testDay;
    }


    public void setTestDay(String testDay) {
        this.testDay = testDay;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public BaiThi getExam() {
        return exam;
    }


    public void setExam(BaiThi exam) {
        this.exam = exam;
    }
    @Override
    public int hashCode() {
        return Objects.hash(pointId); // Sử dụng một thuộc tính đơn lẻ như id thay vì các đối tượng khác có thể gây đệ quy.
    }
}
