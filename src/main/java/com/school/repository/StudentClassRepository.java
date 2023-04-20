package com.school.repository;

import com.school.model.StudentClass;
import com.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {
}
