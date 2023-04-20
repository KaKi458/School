package com.school.repository;

import com.school.model.Mark;
import com.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Long> {
}
