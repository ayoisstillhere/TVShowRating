package com.example.tvshowrating.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class TvShow {
    @Id
    @SequenceGenerator(
            name="tvshow_sequence",
            sequenceName = "tvshow_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String network;
    private LocalDate startDate;
    private Double rating;

    public TvShow() {
    }

    public TvShow(Long id, String name, String network, LocalDate startDate, Double rating) {
        this.id = id;
        this.name = name;
        this.network = network;
        this.startDate = startDate;
        this.rating = rating;
    }

    public TvShow(String name, String network, LocalDate startDate, Double rating) {
        this.name = name;
        this.network = network;
        this.startDate = startDate;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "TvShow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", network='" + network + '\'' +
                ", startDate=" + startDate +
                ", rating=" + rating +
                '}';
    }
}
