package com.prince.classroom.data;

import com.prince.classroom.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by davidprince on 7/31/17.
 */
@Repository
@Transactional
public interface StudentDAO extends CrudRepository<Student, Integer> {
}
