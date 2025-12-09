package WebThiTA.dto.KhoaHocDTO;

import java.util.ArrayList;
import java.util.List;

public class LessonDTO {
    private Long lessonId;
    private String title;
    private List<BaiHocDTO> baiHocs = new ArrayList<>();

    public LessonDTO(Long lessonId, String title) {
        this.lessonId = lessonId;
        this.title = title;
    }

    // getters & setters
    public Long getLessonId() { return lessonId; }
    public void setLessonId(Long lessonId) { this.lessonId = lessonId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<BaiHocDTO> getBaiHocs() { return baiHocs; }
    public void setBaiHocs(List<BaiHocDTO> baiHocs) { this.baiHocs = baiHocs; }
}

