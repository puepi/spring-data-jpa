package databases.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(generator = "teacher_sequence", strategy = GenerationType.SEQUENCE)
    private Long teacherId;
    private String firstName;
    private String lastName;

//    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
//    List<Course> courses;
}
