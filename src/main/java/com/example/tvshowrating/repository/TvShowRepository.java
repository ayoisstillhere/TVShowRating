package com.example.tvshowrating.repository;

import com.example.tvshowrating.model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TvShowRepository extends JpaRepository<TvShow, Long> {

    @Query("SELECT s FROM TvShow s WHERE s.name = ?1")
    Optional<TvShow> findByName(String name);
}
