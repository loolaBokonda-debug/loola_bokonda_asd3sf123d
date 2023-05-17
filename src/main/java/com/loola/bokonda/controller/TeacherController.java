package com.loola.bokonda.controller;

import com.loola.bokonda.model.Teacher;
import com.loola.bokonda.service.implementation.TeacherServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherServiceImp teacherServiceImp;
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody @Valid Teacher teacher){
        return ResponseEntity.ok( teacherServiceImp.create(teacher));

    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAll() {

        List<Teacher> teachers= teacherServiceImp.getAll();
        return ResponseEntity.ok(teachers);
    }
}
