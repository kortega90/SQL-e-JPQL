package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerNameDTO;
import com.devsuperior.uri2602.projection.CustomerNameProjection;
import com.devsuperior.uri2602.respositories.CustomerRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {
    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(Uri2602Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        List<CustomerNameProjection> result = repository.search1("rS");
        List<CustomerNameDTO> result1 = result.stream().map(x -> new CustomerNameDTO(x)).collect(Collectors.toList());

        System.out.println("\n****RESULTADO RAIZ:");
        for (CustomerNameDTO ls: result1 ){
            System.out.println(ls);
        }
        System.out.println("\n\n");

        List<CustomerNameDTO> result2 = repository.search2("RS");

        System.out.println("\n****RESULTADO JPA:");
        for (CustomerNameDTO ls: result2 ){
            System.out.println(ls);
        }

    }
}
