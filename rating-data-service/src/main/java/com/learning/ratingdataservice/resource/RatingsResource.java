package com.learning.ratingdataservice.resource;

import com.learning.ratingdataservice.models.Rating;
import com.learning.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
    @GetMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable int userId){
        List<Rating> ratings = Arrays.asList(
                new Rating(1 , 1),
                new Rating(2,2)
        );

        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }
}
