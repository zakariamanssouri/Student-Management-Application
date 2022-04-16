package ma.enset.web;

import lombok.AllArgsConstructor;
import ma.enset.entities.Gender;
import ma.enset.entities.Student;
import ma.enset.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@Transactional
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
    public String deleteStudent(@RequestParam(name = "id") int id, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        studentRepository.deleteById((long) id);
        return "redirect:/students?page=" + page + "&size=" + size;
    }

    @GetMapping("/admin/students/edit")
    public String editStudent(@RequestParam int id, @RequestParam int page, @RequestParam int size,Model model) {
        model.addAttribute("student", studentRepository.findById((long) id).orElse(null));
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "editStudent";
    }

    @GetMapping("/admin/students/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "newStudent";
    }

    @PostMapping("/admin/students")
    public String saveStudent(@Valid @ModelAttribute("student")  Student student,BindingResult bindingResult,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10")  int size) {
        if(bindingResult.hasErrors()) {
            return "newStudent";
        }
        else {
            studentRepository.save(student);
            return "redirect:/students?page=" + page + "&size=" + size;


        }
    }


}
