package com.loola.bokonda.service.implementation;

import com.loola.bokonda.dao.StudentDao;
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

    private  final StudentDao studentDao;


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
    public List<Student> list(String className, String teacherName, int pageSize, int offSet) {
        log.info("Fetching all students !");
            return studentDao.getAllStudent(className,teacherName, pageSize, offSet);

    }

    @Override
    public Page<Student> studentPagination(int offset, int pageSize) {
        return studentRepo.findAll(PageRequest.of(offset, pageSize));
    }


}
