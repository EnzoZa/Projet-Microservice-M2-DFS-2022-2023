package com.example.howtodoinjava.springhystrixschoolservice.util;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class SpringEurekaMyMovieServiceInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("details",
                Collections.singletonMap("description", "This is the Movie service, which is discovery server aware, and this service will Call Movie Microservice, from Movie details, which is again dicovery server aware!!! "));
    }

}
