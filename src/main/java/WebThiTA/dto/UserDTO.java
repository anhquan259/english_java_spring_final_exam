package WebThiTA.dto;

import WebThiTA.model.Diem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String Fullname;
    private String username;
    private String password;
    private int role;
    private double diemTB;
    private Set<Diem> diem;
}
