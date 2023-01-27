package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDto;
import com.devsuperior.uri2621.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true,value = "SELECT products.name " +
            "FROM products " +
            "INNER JOIN providers ON id_providers = providers.id " +
            "WHERE UPPER (providers.name) LIKE UPPER(CONCAT(:chart,'%')) "+
            "AND amount BETWEEN :min AND :max")
    List<ProductProjection> search1(Integer min,Integer max,String chart);
    @Query ("SELECT new com.devsuperior.uri2621.dto.ProductMinDto (obj.name) " +
            "FROM Product obj " +
            "WHERE UPPER (obj.provider.name) LIKE UPPER(CONCAT(:chart,'%')) "+
            "AND obj.amount BETWEEN :min AND :max")
    List<ProductMinDto> search2(Integer min,Integer max,String chart);
}
