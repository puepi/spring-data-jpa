package databases.repository;

import databases.entity.Course;
import databases.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .url("https://www.google.com")
                .course(Course.builder()
                        .title("Java")
                        .credit(6)
                        .build())
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
}