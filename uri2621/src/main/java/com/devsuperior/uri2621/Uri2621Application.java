package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinDto;
import com.devsuperior.uri2621.projections.ProductProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<ProductProjection> list = repository.search1(10,20,"p");
		List<ProductMinDto> result1 = list.stream().map(x -> new ProductMinDto(x)).collect(Collectors.toList());
		System.out.println("\n ***** RESLT RAIZ:");
		for (ProductMinDto obj: result1 ){
			System.out.println(obj);
		}
		System.out.println("\n\n");
		List<ProductMinDto> result2= repository.search2(10,20,"p");
		System.out.println("\n ***** RESLT RAIZ:");
		for (ProductMinDto obj: result2 ){
			System.out.println(obj);
		}
	}
}
