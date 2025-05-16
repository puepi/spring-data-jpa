package databases.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(generator = "course_sequence", strategy = GenerationType.SEQUENCE)
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    public Long getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", credit=" + credit +
                ", courseMaterial=" + courseMaterial +
                '}';
    }
}
