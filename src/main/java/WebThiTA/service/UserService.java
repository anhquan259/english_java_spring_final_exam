package WebThiTA.service;

import WebThiTA.dto.UserDTO;
import WebThiTA.model.Diem;
import WebThiTA.model.User;
import WebThiTA.reponsitory.UserRepo;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public UserDTO getUserProfile(String username) {
        Optional<User> userOptional = userRepo.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Khởi tạo để tránh lỗi LazyInitializationException
            Hibernate.initialize(user.getDiem());

            // In ra danh sách điểm để kiểm tra
            Set<Diem> diemSet = user.getDiem();
            for (Diem diem : diemSet) {
                logger.info("Exam: {}, Point: {}", diem.getExam().getExamName(), diem.getPoint());
            }

            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);

            return userDTO;
        }

        return null;
    }

    @Transactional
    public String updateUserProfile(String username, String fullname, String password, String newPass, String rePass) {
        logger.info("start call updateUserProfile");
        Optional<User> userOptional = userRepo.findByUsername(username);
        if (userOptional.isEmpty()) {
            return "Người dùng không tồn tại";
        }

        User user = userOptional.get();
        String hashedOldPassword = getSHAHash(password);
        String hashedNewPassword = getSHAHash(newPass);

        logger.info("Mật khẩu cũ đã hash: {}", hashedOldPassword);
        logger.info("Mật khẩu mới đã hash: {}", hashedNewPassword);

        if (!user.getPassword().equals(hashedOldPassword)) {
            logger.error("Mật khẩu cũ không chính xác!");
            return "Mật khẩu cũ không chính xác!";
        }

        if (!newPass.equals(rePass)) {
            logger.error("Mật khẩu mới và xác nhận không khớp!");
            return "Xác nhận mật khẩu không khớp!";
        }

        if (hashedOldPassword.equals(hashedNewPassword)) {
            logger.error("Mật khẩu mới trùng với mật khẩu cũ!");
            return "Mật khẩu mới không được trùng với mật khẩu cũ!";
        }

        // Cập nhật mật khẩu mới
        user.setPassword(hashedNewPassword);
        user.setFullname(fullname);
        logger.info("Mật khẩu mới được set: {}", hashedNewPassword);

        try {
            userRepo.saveAndFlush(user);
            logger.info("Mật khẩu mới đã được cập nhật trong CSDL!");
        } catch (Exception e) {
            logger.error("Lỗi khi cập nhật mật khẩu - {}", e.getMessage());
            return "Lỗi khi cập nhật mật khẩu!";
        }

        return "Cập nhật thành công";
    }

    // Hàm băm mật khẩu bằng SHA-1
    public static String getSHAHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            return convertByteToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertByteToHex(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
