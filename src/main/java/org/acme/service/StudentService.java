package org.acme.service;

import org.acme.entity.Student;
import org.acme.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Inject
    StudentRepository studentRepository;

    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int studentId, Student student) {
        Student newStudent = new Student();
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            existingStudent.get().setStudentName(student.getStudentName());
            newStudent = studentRepository.save(existingStudent.get());
        }
        return newStudent;
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }
}
