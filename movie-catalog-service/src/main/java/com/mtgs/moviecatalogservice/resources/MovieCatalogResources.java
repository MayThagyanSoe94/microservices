package com.mtgs.moviecatalogservice.resources;

import com.mtgs.moviecatalogservice.model.CatalogItem;
import com.mtgs.moviecatalogservice.model.Movie;
import com.mtgs.moviecatalogservice.model.Rating;
import com.mtgs.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);

        List<Rating> ratings = Arrays.asList(
                new Rating("TheShawshankRedemption", 9),
                new Rating("TheGodfather", 8)
        );

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);


            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        }).collect(Collectors.toList());
    }
}

            /*
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
            */
