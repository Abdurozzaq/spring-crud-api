package id.my.rozzaq.springcrudapi.rest;

import id.my.rozzaq.springcrudapi.dao.StudentDAO;
import id.my.rozzaq.springcrudapi.entity.Student;
import id.my.rozzaq.springcrudapi.rest.helper.RestNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    private final StudentDAO studentDAO;

    public StudentRestController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentDAO.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student theStudent = studentDAO.findById(studentId);

        if (theStudent == null) {
            throw new RestNotFoundException("Student not found with id: " + studentId);
        }

        return theStudent;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student payloadData) {
        payloadData.setId(0);

        return studentDAO.save(payloadData);
    }

    @PostMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student payloadData) {
        Student theStudent = studentDAO.findById(studentId);

        if (theStudent == null) {
            throw new RestNotFoundException("Student not found with id: " + studentId);
        }

        theStudent.setFirstName(payloadData.getFirstName());
        theStudent.setLastName(payloadData.getLastName());
        theStudent.setEmail(payloadData.getEmail());

        return studentDAO.update(theStudent);
    }

    @PostMapping("/delete/{studentId}")
    public Student deleteStudent(@PathVariable int studentId) {
        Student theStudent = studentDAO.findById(studentId);

        if (theStudent == null) {
            throw new RestNotFoundException("Student not found with id: " + studentId);
        }

        return studentDAO.deleteById((long) studentId);
    }
}
