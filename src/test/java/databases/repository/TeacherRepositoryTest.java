package databases.repository;

import databases.entity.Course;
import databases.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course = Course.builder()
                .title("JAVA")
                .credit(3)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Meny")
                .lastName("Capomaccio")
                .courses(List.of(course))
                .build();
        teacherRepository.save(teacher);
    }
}