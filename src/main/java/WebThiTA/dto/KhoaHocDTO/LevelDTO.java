package WebThiTA.dto.KhoaHocDTO;

import java.util.ArrayList;
import java.util.List;

public class LevelDTO {
    private Long levelId;
    private String name;
    private List<LessonDTO> lessons = new ArrayList<>();

    public LevelDTO(Long levelId, String name) {
        this.levelId = levelId;
        this.name = name;
    }

    // getters & setters
    public Long getLevelId() { return levelId; }
    public void setLevelId(Long levelId) { this.levelId = levelId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<LessonDTO> getLessons() { return lessons; }
    public void setLessons(List<LessonDTO> lessons) { this.lessons = lessons; }
}

