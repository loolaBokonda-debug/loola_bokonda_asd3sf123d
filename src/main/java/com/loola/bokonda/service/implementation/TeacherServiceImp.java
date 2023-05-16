package com.loola.bokonda.service.implementation;

import com.loola.bokonda.model.Teacher;
import com.loola.bokonda.repository.TeacherRepository;
import com.loola.bokonda.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Slf4j
@Service
public class TeacherServiceImp implements TeacherService {

    private final TeacherRepository teacherRepo;
    @Override
    public Teacher create(Teacher teacher) {
        log.info("saving new teacher {}", teacher.getFirstName());
        return teacherRepo.save(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepo.findAll();
    }
}
