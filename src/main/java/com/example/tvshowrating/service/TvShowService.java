package com.example.tvshowrating.service;

import com.example.tvshowrating.model.TvShow;
import com.example.tvshowrating.repository.TvShowRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class TvShowService {
    private final TvShowRepository tvShowRepository;

    public TvShowService(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    public List<TvShow> getTvShows() {
        return tvShowRepository.findAll();
    }
}
