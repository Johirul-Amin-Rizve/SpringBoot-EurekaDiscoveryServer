package com.learning.moviecatalogservice.resource;

import com.learning.moviecatalogservice.models.CatalogItem;
import com.learning.moviecatalogservice.models.Movie;
import com.learning.moviecatalogservice.models.Rating;
import com.learning.moviecatalogservice.models.UserRating;
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
public class MovieCatalogResource {

    //rest template request
    @Autowired
    private RestTemplate restTemplate;

    //webclient request
//    @Autowired
//    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable int userId){

        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratings/users/"+ userId, UserRating.class);

        return userRating.getRatings().stream().map(rating -> {
            //rest template request
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);

            //webclient request
//            Movie movie = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movies/"+rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();
            return new CatalogItem(movie.getName(), "a", rating.getRating());
        }).collect(Collectors.toList());
    }
}
