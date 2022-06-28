package com.example.tvshowrating.service;

import com.example.tvshowrating.model.TvShow;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class TvShowService {
    public List<TvShow> getTvShows() {
        return List.of(
                new TvShow(
                1L,
                "Umbrella Academy",
                "Netflix",
                LocalDate.of(2019, Month.FEBRUARY,15),
                5.0
                ),
                new TvShow(
                        2L,
                        "The Boys",
                        "Amazon Prime",
                        LocalDate.of(2019, Month.FEBRUARY,15),
                        5.0
                )
        );
    }
}
