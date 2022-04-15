package ma.enset.web;

import lombok.AllArgsConstructor;
import ma.enset.entities.Student;
import ma.enset.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentRepository studentRepository;


    @GetMapping("/students")
    public String getStudents(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "10") int size,
                              @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        Page<Student> students = studentRepository.findByNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("students", students.getContent());
        model.addAttribute("pages", new int[students.getTotalPages()]);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "students";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    @DeleteMapping("/admin/delete")
    public String deleteStudent(@RequestParam(name = "id") int id,@RequestParam(name = "page") int page,@RequestParam(name = "size") int size ){
        studentRepository.deleteById((long) id);
        return "redirect:/students?page="+page+"&size="+size;
    }
}
