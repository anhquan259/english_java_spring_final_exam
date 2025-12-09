package WebThiTA.dto.KhoaHocDTO;

import java.util.ArrayList;
import java.util.List;

public class BaiHocDTO {
    private Long unitId;
    private String title;

    public BaiHocDTO(Long unitId, String title) {
        this.unitId = unitId;
        this.title = title;
    }

    // getters & setters
    public Long getUnitId() { return unitId; }
    public void setUnitId(Long unitId) { this.unitId = unitId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}

