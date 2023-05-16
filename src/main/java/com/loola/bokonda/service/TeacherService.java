package com.loola.bokonda.service;

import com.loola.bokonda.model.Teacher;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface TeacherService {

    Teacher create(Teacher teacher);
    List<Teacher> getAll();
}
