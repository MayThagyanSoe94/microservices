package com.mtgs.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Getter
@lombok.Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {

    private List<Rating> userRating;
}
