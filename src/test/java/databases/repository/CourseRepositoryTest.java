package databases.repository;

import databases.entity.Course;
import databases.entity.Student;
import databases.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseWIthoutCourseMaterial(){
        Course course=Course.builder()
                .title("Algorithms")
                .credit(8)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWIthTeacher(){
        Course course=Course.builder()
                .title("Database")
                .credit(8)
                .teacher(Teacher.builder()
                        .firstName("Rosario")
                        .lastName("Henri")
                        .build())
                .build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseWIthoutTeacher(){
        Course course=Course.builder()
                .title("Web programming")
                .credit(7)
                .build();
        courseRepository.save(course);
    }
    
    @Test
    public void printCourseWithTeacher(){
        List<Course> courses=courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords= PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords=PageRequest.of(1,2);
        List<Course> courses=courseRepository.findAll(firstPageWithThreeRecords).getContent();
        Long totalElements=courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages=courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitleRecords=PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDescRecords=PageRequest.of(0,2,Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDescRecords=PageRequest.of(0,2,Sort.by("title")
                .descending()
                .and(Sort.by("credit")));

        List<Course> courses=courseRepository.findAll(sortByTitleRecords).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printCoursesByTitleContaining(){
        Pageable firstPageWithTenRecords=PageRequest.of(0,10);
        List<Course> courses=courseRepository.findByTitleContaining("D",firstPageWithTenRecords).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Course course=Course.builder()
                .title("Mysql")
                .credit(1)
                .teacher(Teacher.builder()
                        .firstName("Maria")
                        .lastName("Sharapova")
                        .build())
                .students(List.of(
                        Student.builder()
                                .emailId("romarai@hotmail.com")
                                .firstName("romaria")
                                .lastName("pouli")
                                .build()
                ))
                .build();
        courseRepository.save(course);
    }
}