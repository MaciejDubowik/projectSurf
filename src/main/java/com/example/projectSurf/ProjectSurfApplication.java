package com.example.projectSurf;

import com.example.projectSurf.model.Lesson;
import com.example.projectSurf.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjectSurfApplication implements CommandLineRunner {


	@Autowired
	private LessonRepository repo;
	private Lesson les;
	public static void main(String[] args) {
		SpringApplication.run(ProjectSurfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//jesli jest polaczenie z baza danych to wyswietli wiersz
		List<Lesson> creditTableList = repo.findAll();
		creditTableList.forEach(System.out::println);



	}
}
