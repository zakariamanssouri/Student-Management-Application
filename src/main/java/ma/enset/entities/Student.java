package ma.enset.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "the username should not be empty")
    @Size(min = 3, max = 255)
    private String name;

    @NotEmpty(message = "the lastname should not be empty")
    @Size(min = 3, max = 255)
    private String lastName;
    @Column(unique = true)
    private String email;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;
    private Gender gender;
    private boolean enRegle;
}
