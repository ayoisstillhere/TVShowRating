package com.example.tvshowrating.controller;

import com.example.tvshowrating.model.TvShow;
import com.example.tvshowrating.service.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tvshows")
public class TvShowController {
    private final TvShowService tvShowService;

    @Autowired
    public TvShowController(TvShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping
    public List<TvShow> getTvShows() {
        return tvShowService.getTvShows();
    }

    @PostMapping
    public void addTvShow(@RequestBody TvShow tvShow) {
        tvShowService.addTvShow(tvShow);
    }

    @DeleteMapping(path="{Id}")
    public void deleteTvShow(@PathVariable("Id") Long Id) {
        tvShowService.deleteTvShow(Id);
    }
}
