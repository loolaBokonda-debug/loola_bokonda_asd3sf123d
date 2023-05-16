package com.loola.bokonda.ressource;
import com.loola.bokonda.dto.StudentCreateDto;
import com.loola.bokonda.model.Student;
import com.loola.bokonda.service.implementation.StudentServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentRessource {

    private final StudentServiceImp studentServiceImp;
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentCreateDto createDto){

        return ResponseEntity.ok( studentServiceImp.create(createDto));

    }
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(@RequestParam Optional<String> className, @RequestParam Optional<String> teacherName, @RequestParam (defaultValue = "20") int pageSize, @RequestParam (defaultValue = "0") int offSet ) {

       List<Student> students= studentServiceImp.list(className.orElse(null), teacherName.orElse(null), pageSize, offSet);
        return ResponseEntity.ok(students);
    }



}
