package WebThiTA.model;

import java.sql.Clob;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "bai_hoc")
@Data
public class BaiHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    @EqualsAndHashCode.Include
    private Long lessonId;
	@Column(nullable = false)
	private String title;
	@Column(name = "video")
	private String video;
	@Column()
    private String title1;
	@Column(columnDefinition="varchar(1000)")
	private String content1;
	@Column()
    private String title2;
	@Column(columnDefinition="varchar(1000)")
    private String content2;
    @Column()
    private String title3;
    @Column(columnDefinition="varchar(1000)")
    private String content3;
    @Column()
    private String title4;
    @Column(columnDefinition="varchar(1000)")
    private String content4;
	

    public BaiHoc() {
        super();
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

  

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    

    public String getTitle4() {
        return title4;
    }

    public void setTitle4(String title4) {
        this.title4 = title4;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }

    
    
    

    
    
	
}
