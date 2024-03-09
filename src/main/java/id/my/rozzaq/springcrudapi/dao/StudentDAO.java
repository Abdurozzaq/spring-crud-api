package id.my.rozzaq.springcrudapi.dao;

import id.my.rozzaq.springcrudapi.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    void update(Student theStudent);

    void deleteById(Long id);

    Student findById(Integer id);

    List<Student> findAll();
}
