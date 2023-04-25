package com.school.repository;

import com.school.model.Mark;
import com.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {

    List<Mark> findFirst20ByStudentIdOrderByDateDesc(Long studentId);
    List<Mark> findByStudentIdAndSubjectInstanceIdOrderByDateDesc(Long studentId, Long subjectInstanceId);
}
