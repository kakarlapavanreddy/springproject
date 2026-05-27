package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Student;
import Service.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // REGISTER STUDENT
    @PostMapping
    public Student registerStudent(
            @Valid @RequestBody Student student) {

        return service.registerStudent(student);
    }

    // VIEW ALL STUDENTS
    @GetMapping
    public List<Student> getAllStudents() {

        return service.getAllStudents();
    }

    // FIND STUDENT BY ID
    @GetMapping("/{studentId}")
    public Student getStudentById(
            @PathVariable int studentId) {

        return service.getStudentById(studentId);
    }

    // DELETE STUDENT REGISTRATION
    @DeleteMapping("/{studentId}")
    public String deleteStudent(
            @PathVariable int studentId) {

        return service.deleteStudent(studentId);
    }
}