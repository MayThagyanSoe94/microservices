package com.mtgs.ratingsdataservice.resources;

import com.mtgs.ratingsdataservice.model.Rating;
import com.mtgs.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getRatingByUser(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("TheShawshankRedemption", 9),
                new Rating("TheGodfather", 8)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }

}
