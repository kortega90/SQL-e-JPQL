package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieMinDto;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true,value = "SELECT movies.id, name " +
            "FROM movies " +
            "INNER JOIN genres ON id_genres = genres.id " +
            "WHERE UPPER (description) = (UPPER(:genreName)) ")
    List<MovieMinProjection> search1(String genreName);

    @Query("SELECT new com.devsuperior.uri2611.dto.MovieMinDto(obj.id, obj.name) " +
            "FROM Movie obj " +
            "WHERE UPPER(obj.genre.description) = (UPPER(:genreName))")
    List<MovieMinDto> search2(String genreName);
}
