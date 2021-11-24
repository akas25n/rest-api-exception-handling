package com.unitintegrationtesting.service;

import com.unitintegrationtesting.exception.BadRequestException;
import com.unitintegrationtesting.exception.StudentNotFoundException;
import com.unitintegrationtesting.model.Student;
import com.unitintegrationtesting.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) throws BadRequestException {
        Boolean existsEmail = studentRepository.emailTaken(student.getEmail());

        if (existsEmail){
            throw new BadRequestException("Email " + student.getEmail() + " is already taken" );
        }
        studentRepository.save(student);
    }

    public Student findAStudent(Long studentId) throws StudentNotFoundException {
        if (!studentRepository.existsById(studentId)){
            throw new StudentNotFoundException("Student with id " + studentId + " does not exists");
        }
        Student student = studentRepository.getOne(studentId);
        return student;
    }

    public void deleteStudent(Long studentId) throws StudentNotFoundException {
        if (!studentRepository.existsById(studentId)){
            throw new StudentNotFoundException("Student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
