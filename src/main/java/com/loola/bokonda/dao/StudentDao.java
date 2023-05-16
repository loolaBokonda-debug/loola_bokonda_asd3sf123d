package com.loola.bokonda.dao;

import com.loola.bokonda.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class StudentDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> getAllStudent(String className, String teacherFullName, int pageSize, int offSet){



        String sql = "from Student st where 1=1 ";

        if(StringUtils.hasText(className)) {
            sql += " and lower(st.clazz.name) like lower('%" + className + "%')";
        }

        if(StringUtils.hasText(teacherFullName)) {
            sql += " and lower(st.clazz.teacher.firstName ||' '||st.clazz.teacher.lastName) like lower('%" + teacherFullName+ "%')";
        }


         sql+= " order by id ";

        Query query = entityManager.createQuery(sql).setFirstResult(offSet * pageSize).setMaxResults(pageSize);
        List<Student> students = query.getResultList();

        return students;
    }
}
