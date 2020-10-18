package com.learning.ratingdataservice.resource;

import com.learning.ratingdataservice.models.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable int movieId){
        return new Rating(movieId, 1);
    }
}
