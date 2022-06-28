package com.example.tvshowrating.controller;

import com.example.tvshowrating.model.TvShow;
import com.example.tvshowrating.service.TvShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/tvshows")
public class TvShowController {
    private final TvShowService tvShowService;

    public TvShowController(TvShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping
    public List<TvShow> getTvShows() {
        return tvShowService.getTvShows();
    }
}
