package com.school.repository;

import com.school.model.SubjectInstance;
import com.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectInstanceRepository extends JpaRepository<SubjectInstance, Long> {
}
