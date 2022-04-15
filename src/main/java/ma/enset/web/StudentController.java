package ma.enset.web;

import lombok.AllArgsConstructor;
import ma.enset.entities.Student;
import ma.enset.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentRepository studentRepository;


    @GetMapping("/students")
    @ResponseBody
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
