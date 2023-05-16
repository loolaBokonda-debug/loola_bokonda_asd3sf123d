package com.loola.bokonda.service.implementation;

import com.loola.bokonda.dto.ClassCreateDto;
import com.loola.bokonda.model.Clazz;
import com.loola.bokonda.model.Teacher;
import com.loola.bokonda.repository.ClassRepository;
import com.loola.bokonda.repository.TeacherRepository;
import com.loola.bokonda.service.ClassService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Slf4j
@Service
public class ClassServiceImp implements ClassService {

    private final ClassRepository classRepo;
    private  final TeacherRepository teacherRepository;
    @Override
    public Clazz create(ClassCreateDto createDto) {
        Teacher teacher = teacherRepository.findById(createDto.teacherId()).orElseThrow(() -> new NoSuchElementException("Teacher with id " + createDto.teacherId() + " not present"));

        Clazz clazz = Clazz.builder().teacher(teacher).name(createDto.className()).build();
        log.info("Saving a new class {}", clazz.getName());
        return classRepo.save(clazz);
    }

    @Override
    public List<Clazz> getAll() {

        return classRepo.findAll();
    }
}
