package com.example.DAOLayer;
import org.springframework.stereotype.Repository;

import com.example.Entity.Student;
@Repository
public interface DaoMethods {
public Student create(Student student);
public Student read(int id);
public Student update(Student s);
public Student delete(int id);
}
