package ma.enset.repositories;

import ma.enset.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findByNameContains(String string, org.springframework.data.domain.Pageable pageable);
}
