package com.devsuperior.uri2602.respositories;

import com.devsuperior.uri2602.dto.CustomerNameDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projection.CustomerNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long>{

    @Query(nativeQuery = true,value = "Select name " +
            "FROM customers " +
            "where UPPER(state) = UPPER(:state)")
    List<CustomerNameProjection> search1(String state);

    @Query("Select new com.devsuperior.uri2602.dto.CustomerNameDTO(obj.name) " +
            "FROM Customer obj " +
            "WHERE UPPER(obj.state) = UPPER(:state) ")
    List<CustomerNameDTO> search2(String state);
}
