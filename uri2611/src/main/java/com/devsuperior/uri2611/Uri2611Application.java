package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDto;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieMinProjection> list = repository.search1("Action");
		List<MovieMinDto> result1= list.stream().map(x -> new MovieMinDto(x)).collect(Collectors.toList());

		System.out.println("\n\n ***** RESULT SQL RAIZ: ");
		for (MovieMinDto obj: result1){
			System.out.println(obj);
		}
		System.out.println("\n\n");
		List<MovieMinDto> result2= repository.search2("Action");

		System.out.println("\n ***** RESULT JPQL RAIZ: ");
		for (MovieMinDto obj: result2){
			System.out.println(obj);
		}
	}
}
