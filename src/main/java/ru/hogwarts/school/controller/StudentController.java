package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudentForId(@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @GetMapping
    public Student findStudentByAge(@RequestParam Long ageAfter,
                                    @RequestParam Long ageBefore) {
        return studentService.findStudentByAge(ageAfter, ageBefore);
    }

    @GetMapping("/faculty")
    public Student findFacultyOfStudent(@RequestParam Faculty faculty) {
        return studentService.findStudent(faculty.getId());
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @PutMapping()
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}