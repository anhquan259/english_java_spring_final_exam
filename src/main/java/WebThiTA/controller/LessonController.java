package WebThiTA.controller;
// LessonController.java


import WebThiTA.model.Lesson;
import WebThiTA.reponsitory.LessonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class LessonController {

    @Autowired
    private LessonRepo lessonService;

    // Nếu Lesson là Master Data độc lập, phương thức GET chỉ cần hiển thị form.
    // Tham số levelId (optional) chỉ dùng cho mục đích chuyển hướng quay lại trang danh sách.
    @GetMapping("/add-lesson")
    public String showAddLessonForm( Model model) {

        Lesson lessonDTO = new Lesson();

        model.addAttribute("lessonDTO", lessonDTO);
        // levelId chỉ được truyền vào Model để phục vụ cho nút Quay lại (Nếu muốn)

        return "addLesson"; // Trả về view: add-lesson.html
    }

    /**
     * [POST] Xử lý việc thêm Lesson Master Data mới
     */
    @PostMapping("/add-lesson")
    public String addLesson(@ModelAttribute("lessonDTO") Lesson lessonDTO,
                            BindingResult result,
                            @RequestParam(name = "levelIdForRedirect", required = false) Long levelIdForRedirect, // Nhận levelId từ form (trường ẩn)
                            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            // Nếu có lỗi validation, quay lại form
            // levelIdForRedirect không cần thiết ở đây nếu form không cần nó
            return "addLesson";
        }

        try {
            // Logic lưu Lesson Master Data (LessonService sẽ map DTO sang Entity)
            lessonService.save(lessonDTO);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm Lesson Master Data mới thành công!");

            // Chuyển hướng về trang danh sách khóa học
            return "redirect:/khoahoc/add";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi khi thêm Lesson: " + e.getMessage());
            // Quay lại trang danh sách, hoặc form với levelId (nếu cần)
            return "redirect:/khoahoc/add";
        }
    }
}