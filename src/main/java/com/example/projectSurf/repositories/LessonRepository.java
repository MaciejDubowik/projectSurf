package com.example.projectSurf.repositories;

import com.example.projectSurf.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
