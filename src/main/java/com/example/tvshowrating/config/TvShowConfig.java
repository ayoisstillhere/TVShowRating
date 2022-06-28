package com.example.tvshowrating.config;

import com.example.tvshowrating.model.TvShow;
import com.example.tvshowrating.repository.TvShowRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TvShowConfig {
    @Bean
    CommandLineRunner commandLineRunner(TvShowRepository repository) {

        return args -> {
           TvShow brelly =  new TvShow(
                    1L,
                    "Umbrella Academy",
                    "Netflix",
                    LocalDate.of(2019, Month.FEBRUARY, 15),
                    5.0
            );
           TvShow boys = new TvShow(
                   2L,
                   "The Boys",
                   "Amazon Prime",
                   LocalDate.of(2019, Month.FEBRUARY, 15),
                   5.0
           );
           repository.saveAll(List.of(brelly, boys));
        };

    }
}
