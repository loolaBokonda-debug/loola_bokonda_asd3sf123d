package com.loola.bokonda.service.implementation;

import com.loola.bokonda.dto.StudentCreateDto;
import com.loola.bokonda.model.Clazz;
import com.loola.bokonda.model.Student;
import com.loola.bokonda.repository.ClassRepository;
import com.loola.bokonda.repository.StudentRepository;
import com.loola.bokonda.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Slf4j
@Service
public class StudentServiceImp implements StudentService {


    private final   StudentRepository studentRepo;

    private final ClassRepository classRepository;



    @Override
    public Student create(StudentCreateDto createDto) {
        Clazz clazz = classRepository.findById(createDto.classId()).orElseThrow(() -> new NoSuchElementException("Class with id " + createDto.classId() + " not present"));

        Student student = Student.builder().
        clazz(clazz).fistName(createDto.fistName())
        .lastName(createDto.lastName())
        .build();

        log.info("Saving a new student {} ", student.getFistName());
        return studentRepo.save(student);
    }

    @Override
    public List<Student> list(String className, String teacherFirstName, String teacherlastName, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Student> pageStudents;
        log.info("Fetching all students !");
            if(className == null && teacherFirstName == null && teacherlastName == null) {
                pageStudents = studentRepo.findAll(paging);
                return pageStudents.getContent();
            }
            if (className != null && teacherFirstName == null && teacherlastName == null) {
                 pageStudents = studentRepo.findByClazz_name(className, paging);
                  return pageStudents.getContent();
            }
            if (className == null && teacherFirstName != null && teacherlastName != null) {
                pageStudents = studentRepo.findByClazz_teacher_firstNameAndClazz_teacher_lastName(teacherFirstName, teacherlastName, paging);
                   return pageStudents.getContent();
            }

            pageStudents = studentRepo.findByClazz_nameAndClazz_teacher_firstNameAndClazz_teacher_lastName(className, teacherFirstName, teacherlastName, paging);

            return pageStudents.getContent();
    }


}
