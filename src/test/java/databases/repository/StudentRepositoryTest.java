package databases.repository;

import databases.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository   studentRepository;

    @Test
    public void saveStudent(){
        Student student= Student.builder()
                .emailId("4D0oQ@example.com")
                .firstName("Ravi")
                .lastName("Kumar")
                .guardianName("Ravi Kumar")
                .guardianEmail("pmandel0001@yahoo.fr")
                .guardianMobile("1234567890")
                .build();

        studentRepository.save(student);
    }
}