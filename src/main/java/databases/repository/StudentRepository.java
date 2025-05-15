package databases.repository;

import databases.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByGuardianName(String guardianName);

    //JPQL
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //SQL
    @NativeQuery("select first_name from tbl_student where email_address=?1")
    String getStudentFirstNameByEmailAddressNativeQuery(String emailAddress);

    @NativeQuery("select * from tbl_student where email_address=:emailId")
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @NativeQuery("update tbl_student set first_name=:firstName where email_address=:emailId")
    int updateStudentFirstNameByEmailAddress(@Param("firstName") String firstName, @Param("emailId") String emailId);

}
