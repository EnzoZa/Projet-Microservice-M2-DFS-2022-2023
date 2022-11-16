package com.example.howtodoinjava.springhystrixschoolservice.delegate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class MyMovieServiceDelegate {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
    public String callMyMovieServiceGetMovieByTitle(String title) {
        System.out.println("Getting movie details for " + title);
        String response = restTemplate.exchange(
                "http://localhost:8080/films/title/{title}",
                HttpMethod.GET,
                null, String.class, title).getBody();
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - Title -  " + title + " :::  Movie Details " + response;
    }

    public String callMyMovieServiceAndGetData_Fallback(String title) {
        System.out.println("Student Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. Service will be back shortly - " + " :::  " + " title -  " + title + " :::  " + "Student Details - Not Available at this moment";
    }

    @HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
    public String callMyMovieServiceGetMovieByReleaseDate (String releaseDate) {
        System.out.println("Getting movie details for " + releaseDate);
        String response = restTemplate.exchange(
                "http://localhost:8080/films/releaseDate/{releaseDate}",
                HttpMethod.GET,
                null, String.class, releaseDate).getBody();
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - Release Date -  " + releaseDate + " :::  Movie Details " + response;
    }

    @HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
    public String callMyMovieServiceGetMovies () {
        System.out.println("Getting movie details for ");
        String response = restTemplate.exchange(
                "http://localhost:8080/films",
                HttpMethod.GET,
                null, String.class).getBody();
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! -  Movie Details " + response;
    }

    @HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
    public String callMyMovieServiceGetActors () {
        System.out.println("Getting actor details for ");
        String response = restTemplate.exchange(
                "http://localhost:8080/actors",
                HttpMethod.GET,
                null, String.class).getBody();
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! -  Actor Details " + response;
    }

    @HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
    public String callMyMovieServiceGetActorsByLastName (String lastName) {
        System.out.println("Getting actor details for " + lastName);
        String response = restTemplate.exchange(
                "http://localhost:8080/actors/lastName/{lastName}",
                HttpMethod.GET,
                null, String.class, lastName).getBody();
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - Last Name -  " + lastName + " :::  Actor Details " + response;
    }

    @HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
    public String callMyMovieServiceGetActorsByFirstName (String firstName) {
        System.out.println("Getting actor details for " + firstName);
        String response = restTemplate.exchange(
                "http://localhost:8080/actors/firstName/{firstName}",
                HttpMethod.GET,
                null, String.class, firstName).getBody();
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - First Name -  " + firstName + " :::  Actor Details " + response;
    }

    @HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
    public String callMyMovieServiceGetActorsByMovie (String movie) {
        System.out.println("Getting actor details for " + movie);
        String response = restTemplate.exchange(
                "http://localhost:8080/actors/title/{movie}",
                HttpMethod.GET,
                null, String.class, movie).getBody();
        System.out.println("Response Received as " + response);
        return "NORMAL FLOW !!! - Movie -  " + movie + " :::  Actor Details " + response;
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
