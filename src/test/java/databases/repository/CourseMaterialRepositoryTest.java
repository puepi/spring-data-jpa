package databases.repository;

import databases.entity.Course;
import databases.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course=Course.builder()
                .title("JAVA")
                .credit(5)
                .build();
        CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .url("https://www.coursera.org")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void saveCourseMaterialWithoutCourse(){
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.openclassrooms.fr")
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }
}