package databases.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @GeneratedValue(generator = "course_material_sequence", strategy = GenerationType.SEQUENCE)
    private Long courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;

//    @Override
//    public String toString() {
//        return "CourseMaterial{" +
//                "courseMaterialId=" + courseMaterialId +
//                ", url='" + url + '\'' +
//                ", course={courseId=" + course.getCourseId() + ", title='" + course.getTitle() + '\'' + ", credit=" + course.getCredit() + '}' +
//                '}';
//    }
}
