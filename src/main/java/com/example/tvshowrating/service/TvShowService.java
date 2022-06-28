package com.example.tvshowrating.service;

import com.example.tvshowrating.model.TvShow;
import com.example.tvshowrating.repository.TvShowRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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
            throw new IllegalStateException("tvshow with id " + id + " does not exist");
        }
        tvShowRepository.deleteById(id);
    }

    @Transactional
    public void updateTvShow(Long id, String name, String network, Double rating) {
        TvShow tvShow = tvShowRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("tv show with id " + id + " doesn't exist"));
        if(network != null && network.length() > 0 && !Objects.equals(tvShow.getNetwork(), network)) {
            tvShow.setNetwork(network);
        }
        if(rating != null && !Objects.equals(tvShow.getRating(), rating)) {
            tvShow.setRating(rating);
        }

        if (name != null && name.length() > 0 && !Objects.equals(tvShow.getName(), name)) {
            Optional<TvShow> studentOptional = tvShowRepository.findByName(name);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("name taken");
            }
            tvShow.setName(name);
        }
    }
}
