package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public List<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findAll().stream().filter(e -> e.getColor().equals(color)).toList();
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public Faculty findByNameIgnoreCaseOrColorIgnoreCase(String name, String color) {
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }

    public Collection<Student> findByName(String name) {
        Faculty f = facultyRepository.findFacultyByNameIgnoreCase(name);
        return f.getStudentCollection();
    }

    public String getAllStudents() {
        String count = " " + facultyRepository.getAllStudents() + " ";
        return "количество студентов в школе: " + count;
    }

    public String getAvgAge() {
        String age = " " + facultyRepository.getAvgAge() + " ";
        return "средний возраст студентов в школе: " + age;
    }

}