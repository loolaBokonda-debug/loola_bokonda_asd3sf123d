package com.loola.bokonda;

import com.loola.bokonda.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LoolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoolaApplication.class, args);
	}

	/*CommandLineRunner run(ClassRepository classRepo){
		return args -> {
			classRepo.save(new Clazz(null, "class-1", ));
		};
	}
*/
	@Bean
	CommandLineRunner run(StudentRepository studentRepo){
		return args -> {
/*			studentRepo.save(new Student(null, "Moussa", "SIDIBE"));
			studentRepo.save(new Student(null, "Kenaya", "Bokonda"));
			studentRepo.save(new Student(null, "Fidèle", "Loola Esingi"));
			studentRepo.save(new Student(null, "Rodrigue", "Nkoloma"));
			studentRepo.save(new Student(null, "Prisca", "Biadam Bokonda"));*/
		};
	}
}
