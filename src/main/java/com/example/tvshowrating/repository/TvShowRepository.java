package com.example.tvshowrating.repository;

import com.example.tvshowrating.model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TvShowRepository extends JpaRepository<TvShow, Long> {
}
