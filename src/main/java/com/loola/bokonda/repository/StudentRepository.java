package com.loola.bokonda.repository;

import com.loola.bokonda.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByClazz_name(String className, Pageable pageable);

    Page<Student> findByClazz_teacher_firstNameAndClazz_teacher_lastName(String teacherFirstName, String teacherlastName, Pageable pageable);

    Page<Student> findByClazz_nameAndClazz_teacher_firstNameAndClazz_teacher_lastName(String className, String teacherFirstName, String teacherlastName, Pageable pageable);


}
