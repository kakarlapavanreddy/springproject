package Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Model.Student;

@Service
public class StudentService {

    // Temporary storage
    private List<Student> studentList = new ArrayList<>();

    // REGISTER STUDENT
    public Student registerStudent(Student student) {

        studentList.add(student);

        return student;
    }

    // VIEW ALL STUDENTS
    public List<Student> getAllStudents() {

        return studentList;
    }

    // FIND STUDENT BY ID
    public Student getStudentById(int studentId) {

        for (Student student : studentList) {

            if (student.getStudentId() == studentId) {

                return student;
            }
        }

        throw new RuntimeException(
                "Student not found with ID : " + studentId);
    }

    // DELETE STUDENT REGISTRATION
    public String deleteStudent(int studentId) {

        Student student = getStudentById(studentId);

        studentList.remove(student);

        return "Student registration deleted successfully";
    }
}