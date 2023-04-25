package com.school.mapper;

import com.school.dto.*;
import com.school.model.*;

public interface Mapper {


    AbsenceDTO map(Absence absence);
    LessonDTO map(Lesson lesson);
    MarkDTO map(Mark mark);
    SchoolYearDTO map(SchoolYear schoolYear);
    SemesterDTO map(Semester semester);
    StudentClassDTO map(StudentClass studentClass);
    StudentDTO map(Student student);
    SubjectDTO map(Subject subject);
    SubjectInstanceDTO map(SubjectInstance subjectInstance);
    TeacherDTO map(Teacher teacher);

}
