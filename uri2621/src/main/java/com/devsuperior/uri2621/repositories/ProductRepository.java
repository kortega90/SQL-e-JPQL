package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDto;
import com.devsuperior.uri2621.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    @Query(nativeQuery = true,value = "SELECT public.products.name " +
            "FROM public.products" +
            "INNER JOIN public.providers ON id_providers = public.providers.id " +
            "WHERE UPPER (providers.name) LIKE UPPER ('P%')" +
            "AND amount BETWEEN 10 AND 20 ")
    List<ProductProjection> search1();

}
