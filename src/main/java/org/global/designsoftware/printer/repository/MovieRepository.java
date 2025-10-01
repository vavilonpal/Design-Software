package org.global.designsoftware.printer.repository;

import org.global.designsoftware.entity.Movie;
import org.global.designsoftware.printer.MovieUtils;
import org.global.designsoftware.printer.patterns.MovieFieldMask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Repository
public  interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByTitle(String title);
}
