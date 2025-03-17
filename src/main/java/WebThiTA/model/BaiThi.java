package WebThiTA.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bai_thi")
@Data
public class BaiThi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    @EqualsAndHashCode.Include
    private Long examId;
    @Column(nullable = false, name = "exam_name")
    private String examName;
    @Column(columnDefinition = "varchar(1000)")
    private String content;


    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @ToString.Exclude
    private Set<Diem> listDiem;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    @ToString.Exclude
    private Set<CauHoi> listQuestion;

    public BaiThi() {
        super();
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Diem> getListDiem() {
        return listDiem;
    }

    public void setListDiem(Set<Diem> listDiem) {
        this.listDiem = listDiem;
    }

    public Set<CauHoi> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(Set<CauHoi> listQuestion) {
        this.listQuestion = listQuestion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId);  // Sử dụng chỉ `examId` để tránh vòng lặp vô hạn
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaiThi baiThi = (BaiThi) o;
        return Objects.equals(examId, baiThi.examId);  // Sử dụng chỉ `examId` để so sánh
    }

}