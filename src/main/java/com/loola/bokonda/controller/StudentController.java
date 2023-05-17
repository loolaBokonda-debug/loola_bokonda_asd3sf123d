package com.loola.bokonda.controller;
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
public class StudentController {

    private final StudentServiceImp studentServiceImp;
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentCreateDto createDto){

        return ResponseEntity.ok( studentServiceImp.create(createDto));

    }
      @GetMapping
    public ResponseEntity<List<Student>> getStudents(@RequestParam Optional<String> className,
                                                     @RequestParam Optional<String> teacherfirstName,
                                                     @RequestParam Optional<String> teacherlastName,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "2") int size) {

       List<Student> students= studentServiceImp.list(className.orElse(null), teacherfirstName.orElse(null),
                                                    teacherlastName.orElse(null), page, size);
        return ResponseEntity.ok(students);
    }


}
