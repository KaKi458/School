package com.school.repository;

import com.school.model.Semester;
import com.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
