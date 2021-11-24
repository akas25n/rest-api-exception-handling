package com.unitintegrationtesting.controller;

import com.unitintegrationtesting.exception.BadRequestException;
import com.unitintegrationtesting.model.Student;
import com.unitintegrationtesting.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping(path = "api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody Student student) throws BadRequestException {
        studentService.addStudent(student);
    }

    @RequestMapping(path = "/{studentId}")
    public Student findStudent(@PathVariable("studentId") Long studentId) {
        return studentService.findAStudent(studentId);
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
