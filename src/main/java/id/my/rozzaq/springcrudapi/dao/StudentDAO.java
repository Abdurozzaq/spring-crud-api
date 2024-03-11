package id.my.rozzaq.springcrudapi.dao;

import id.my.rozzaq.springcrudapi.entity.Student;
import java.util.List;

public interface StudentDAO {

    Student save(Student theStudent);

    Student update(Student theStudent);

    Student deleteById(Long id);

    Student findById(Integer id);

    List<Student> findAll();
}
