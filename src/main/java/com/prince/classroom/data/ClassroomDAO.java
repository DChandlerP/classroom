package com.prince.classroom.data;

import com.prince.classroom.models.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by davidprince on 8/1/17.
 */
@Repository
@Transactional
public interface ClassroomDAO extends CrudRepository<Classroom, Integer >{
}
