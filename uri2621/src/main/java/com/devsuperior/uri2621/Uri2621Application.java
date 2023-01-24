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

		List<ProductProjection> list = repository.search1();
		List<ProductMinDto> result1 = list.stream().map(x -> new ProductMinDto(x)).collect(Collectors.toList());
		for (ProductMinDto obj: result1 ){
			System.out.println(obj);
		}
	}
}
