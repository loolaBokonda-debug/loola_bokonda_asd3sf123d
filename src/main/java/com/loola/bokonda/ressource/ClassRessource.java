package com.loola.bokonda.ressource;

import com.loola.bokonda.dto.ClassCreateDto;
import com.loola.bokonda.model.Clazz;
import com.loola.bokonda.service.implementation.ClassServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/class")
public class ClassRessource {

    private final ClassServiceImp classServiceImp;

    @PostMapping
    public ResponseEntity<Clazz> createClass(@RequestBody @Valid ClassCreateDto createDto){
        return ResponseEntity.ok(classServiceImp.create(createDto)

        );

    }

    @GetMapping
    public ResponseEntity<List<Clazz>> getAll() {

        List<Clazz> clazzList = classServiceImp.getAll();
        return ResponseEntity.ok(clazzList);
    }

}
