package com.example.projectSurf;

import com.example.projectSurf.dtos.LessonBookingDto;
import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.model.Student;
import com.example.projectSurf.repositories.LessonRepository;
import com.example.projectSurf.repositories.StudentRepository;
import com.example.projectSurf.services.LessonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjectSurfApplication implements CommandLineRunner {


	@Autowired
	private StudentRepository repo;
	@Autowired
	private LessonRepository lessonRepo;
	@Autowired
	private LessonServiceImpl lessonService;
	private Student les;


	public static void main(String[] args) {
		SpringApplication.run(ProjectSurfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//jesli jest polaczenie z baza danych to wyswietli wiersz
		List<Student> creditTableList = repo.findAll();
//		List<Lesson> lessonList = lessonRepo.findAll();
		List<Lesson> lessonList = lessonService.listAll();
//		creditTableList.forEach(System.out::println);

		lessonList.forEach(System.out::println);

	}
}
