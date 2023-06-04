package com.school.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private MarkValue value;

    @CreationTimestamp
    private LocalDateTime createdTimestamp;

    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Student student;

    @ManyToOne
    private SubjectInstance subjectInstance;
}
