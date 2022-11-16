package com.example.howtodoinjava.springhystrixschoolservice.controller;

import com.example.howtodoinjava.springhystrixschoolservice.delegate.MyMovieServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//ce microservice doit pouvoir accéder à tout ce qui est exposé par “my-movie” et l’exposer lui à son tour sur un endpoint particulier
@RestController
public class MyMovieServiceController {

    @Autowired
    MyMovieServiceDelegate myMovieServiceDelegate;

    @GetMapping("/getMovieByTitle/{title}")
    public String getMovies(@PathVariable String title) {
        System.out.println("Getting Movie details for " + title);
        String response = myMovieServiceDelegate.callMyMovieServiceGetMovieByTitle(title);
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - Movie Title -  " + title + " :::  Movie Details " + response;
    }

    @GetMapping("/getMovieByReleaseDate/{releaseDate}")
    public String getMoviesByReleaseDate(@PathVariable String releaseDate) {
        System.out.println("Getting Movie details for " + releaseDate);
        String response = myMovieServiceDelegate.callMyMovieServiceGetMovieByReleaseDate(releaseDate);
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - Movie Release Date -  " + releaseDate + " :::  Movie Details " + response;
    }

    @GetMapping("/getActorByLastName/{lastName}")
    public String getActorByLastName(@PathVariable String lastName) {
        System.out.println("Getting Actor details for " + lastName);
        String response = myMovieServiceDelegate.callMyMovieServiceGetActorsByLastName(lastName);
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - Actor Last Name -  " + lastName + " :::  Actor Details " + response;
    }

    @GetMapping("/getActorByFirstName/{firstName}")
    public String getActorByFirstName(@PathVariable String firstName) {
        System.out.println("Getting Actor details for " + firstName);
        String response = myMovieServiceDelegate.callMyMovieServiceGetActorsByFirstName(firstName);
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - Actor First Name -  " + firstName + " :::  Actor Details " + response;
    }

    @GetMapping("/getAllActors")
    public String getAllActors() {
        System.out.println("Getting all Actors");
        String response = myMovieServiceDelegate.callMyMovieServiceGetActors();
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - All Actors -  " + response;
    }

}
