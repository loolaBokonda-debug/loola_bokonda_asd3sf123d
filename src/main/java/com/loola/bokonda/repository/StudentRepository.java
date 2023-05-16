package com.loola.bokonda.repository;

import com.loola.bokonda.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

   // List<Student> findByClassSt_nameOrTeachers_firstName(String className, String teacherName);

}
