package com.example.projectSurf.repositories;

import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static javax.swing.text.html.HTML.Tag.SELECT;
import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
