package com.example.projectSurf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Time;

@SpringBootTest
class ProjectSurfApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(Date.valueOf("2021-11-13"));
		System.out.println(Time.valueOf("15:00:00"));

		System.out.println("hello");
	}

}
