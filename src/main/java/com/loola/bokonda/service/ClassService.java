package com.loola.bokonda.service;

import com.loola.bokonda.dto.ClassCreateDto;
import com.loola.bokonda.model.Clazz;

import java.util.List;

public interface ClassService {
    Clazz create(ClassCreateDto createDto);
    List<Clazz> getAll();
}
