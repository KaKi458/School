package com.school.repository;

import com.school.model.SchoolYear;
import com.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Long>  {
}
