package WebThiTA.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "cau_hoi")
@Data
public class CauHoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    @EqualsAndHashCode.Include
    private Long questionId;
	@Column(nullable = false)
	private String question;
	@Column(nullable = false)
    private String option1;
	@Column(nullable = false)
    private String option2;
	@Column(nullable = false)
    private String option3;
	@Column(nullable = false)
    private String option4;
	@Column(name = "correctanswer")
    private String correctanswer;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="exam_id", nullable = false, referencedColumnName = "exam_id")
	@JsonBackReference
    @ToString.Exclude
	private BaiThi exam;

    public CauHoi() {
        super();
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    

    public BaiThi getExam() {
        return exam;
    }

    public void setExam(BaiThi exam) {
        this.exam = exam;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }
    
	
}