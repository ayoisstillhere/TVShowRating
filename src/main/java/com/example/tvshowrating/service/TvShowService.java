package com.example.tvshowrating.service;

import com.example.tvshowrating.model.TvShow;
import com.example.tvshowrating.repository.TvShowRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class TvShowService {
    private final TvShowRepository tvShowRepository;

    public TvShowService(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    public List<TvShow> getTvShows() {
        return tvShowRepository.findAll();
    }

    public void addTvShow(TvShow tvShow) {
        Optional<TvShow> tvShowOptional = tvShowRepository.findByName(tvShow.getName());
        if(tvShowOptional.isPresent()) {
            throw new IllegalStateException("TV show already exists here");
        }
        tvShowRepository.save(tvShow);
    }

    public void deleteTvShow(Long id) {
        boolean exists = tvShowRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("tvshow with id " + " does not exist");
        }
        tvShowRepository.deleteById(id);
    }
}
