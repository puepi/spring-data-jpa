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
                .title("Nodejs")
                .credit(1)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Meny")
                .lastName("Capomaccio")
                //.courses(List.of(course))
                .build();
        teacherRepository.save(teacher);
    }
    
    @Test
    public void printTeachers(){
        List<Teacher> teachers=teacherRepository.findAll();
        System.out.println("teachers = " + teachers);
    }
    
}