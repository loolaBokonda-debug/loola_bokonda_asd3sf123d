package com.loola.bokonda.service;

import com.loola.bokonda.dto.StudentCreateDto;
import com.loola.bokonda.model.Student;
import java.util.List;

public interface StudentService {
    Student create(StudentCreateDto createDto);
    List<Student> list(String className, String teacherFirstName,
                       String teacherlastName, int page, int size);

}
