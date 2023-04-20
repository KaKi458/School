package com.school.repository;

import com.school.model.Subject;
import com.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
