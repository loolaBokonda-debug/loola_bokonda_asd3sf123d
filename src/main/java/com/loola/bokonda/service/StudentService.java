package com.loola.bokonda.service;

import com.loola.bokonda.dto.StudentCreateDto;
import com.loola.bokonda.model.Student;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface StudentService {

    Student create(StudentCreateDto createDto);
    List<Student> list(String className, String teacherName, int pageSize, int offSet);
    Page<Student> studentPagination(int offset, int pageSize);
}
