package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2990.entities.Empregado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

    @Query(nativeQuery = true,value = "SELECT emp.cpf, emp.enome, dep.dnome " +
            "FROM empregados as emp " +
            "INNER JOIN departamentos as dep on emp.dnumero = dep.dnumero " +
            "WHERE cpf NOT IN (SELECT cpf " +
            "FROM empregados " +
            "INNER JOIN trabalha as tra on emp.cpf =tra.cpf_emp) " +
            "ORDER BY cpf ASC ")
    List<EmpregadoDeptProjection> search1();

    @Query("SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO (obj.cpf, obj.enome, obj.departamento.dnome) " +
            "FROM Empregado obj " +
            "WHERE cpf NOT IN (SELECT obj.cpf " +
            "FROM Empregado obj " +
            "INNER JOIN obj.projetosOndeTrabalha) " +
            "ORDER BY obj.cpf ASC ")
    List<EmpregadoDeptDTO> search2();
}
