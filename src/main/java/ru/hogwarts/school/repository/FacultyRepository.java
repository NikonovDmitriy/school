package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    Faculty findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

    Faculty findFacultyByNameIgnoreCase(String name);

    @Query(value = "SELECT count(faculty_id) FROM student", nativeQuery = true)
    Integer getAllStudents();

    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    Integer getAvgAge();
}