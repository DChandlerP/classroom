package com.prince.classroom.data;

import com.prince.classroom.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by davidprince on 7/31/17.
 */
@Repository
@Transactional
public interface StudentDAO extends CrudRepository<Student, Integer> {
    List<Student> findByStudentLastNameIgnoreCase(String lastName);
    List<Student> findByStudentFirstNameIgnoreCase(String firstName);
    List<Student> findByStudentStudentID(String studentID);
    List<Student> findByStudentFirstNameAndLastNameIgnoreCase(String firstName, String lastName);

    //Could Append Like for Names
}
