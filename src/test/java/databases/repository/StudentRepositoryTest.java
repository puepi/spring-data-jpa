package databases.repository;

import databases.entity.Guardian;
import databases.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
                //.guardianName("Ravi Kumar")
                //.guardianEmail("pmandel0001@yahoo.fr")
                //.guardianMobile("1234567890")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void listAllStudents(){
        List<Student> studentList= studentRepository.findAll();
        System.out.println("students = " + studentList);
    }

    @Test
    public void  saveStudentWithGuardian() {
        Student student = Student.builder()
                .emailId("alidou@example.com")
                .firstName("Hembep")
                .lastName("Ezo")
                .guardian(Guardian.builder()
                        .name("Osir")
                        .email("pou@publi.com")
                        .mobile("3321447896")
                        .build())
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Hembep");
        System.out.println("studentList = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("p");
        System.out.println("studentList = " + students);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Tolo");
        System.out.println("studentList = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("alidou@example.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String name = studentRepository.getStudentFirstNameByEmailAddress("alidou@example.com");
        System.out.println("student = " + name);
    }

    @Test
    public void printStudentFirstNameByEmailAddressNativeQuery() {
        String name = studentRepository.getStudentFirstNameByEmailAddressNativeQuery("alidou@example.com");
        System.out.println("student = " + name);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("karoud@example.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentFirstNameByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("alidou@example.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentFistNameByEmailAddress() {
        int update = studentRepository.updateStudentFirstNameByEmailAddress("Mandela","alidou@example.com");
        System.out.println("update = " + update);
    }
}