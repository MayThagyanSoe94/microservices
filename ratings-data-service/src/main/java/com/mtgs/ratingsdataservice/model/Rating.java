package com.mtgs.ratingsdataservice.model;

import lombok.AllArgsConstructor;

@lombok.Getter
@lombok.Setter
@AllArgsConstructor
public class Rating {

    private String movieId;

    private int rating;
}
