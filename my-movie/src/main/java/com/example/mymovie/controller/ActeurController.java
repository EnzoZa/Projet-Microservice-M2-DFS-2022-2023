package com.example.mymovie.controller;
import com.example.mymovie.model.Acteur;
import com.example.mymovie.model.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "ActeurController", description = "REST APIs related to Acteur Entity!!!!")
@RestController
public class ActeurController {
    private List<Film> films = new ArrayList<>();
    private List<Acteur> actors = new ArrayList<>();

    {
        films.add(new Film("The_Godfather", "Francis Ford Coppola", "Marlon Brando", "1972"));
        films.add(new Film("The_Shawshank_Redemption", "Frank Darabont", "Tim Robbins", "1994"));
        films.add(new Film("The_Dark_Knight", "Christopher Nolan", "Christian Bale", "2008"));

        actors.add(new Acteur("Marlon", "Brando", "1924", ""));
        actors.add(new Acteur("Tim", "Robbins", "1958", ""));
        actors.add(new Acteur("Christian", "Bale", "1974", ""));
    }

    @ApiOperation(value = "Get list of all actors", response = Iterable.class, tags = "getActors")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    //tous les acteurs
    @GetMapping("/actors")
    public List<Acteur> getActors() {
        return actors;
    }

    //par nom
    @ApiOperation(value = "Get actors by name", response = Iterable.class, tags = "getActorsByName")
    @GetMapping("/actors/lastName/{lastName}")
    public Acteur getActorsByLastName(@PathVariable String lastName) {
        Acteur actor = new Acteur("", "", "", "");
        for (Acteur a : actors) {
            if (a.getLastName().equals(lastName)) {
                actor = a;
            }
        }
        return actor;
    }

    //récupérer les acteurs selon le titre du film
    @ApiOperation(value = "Get actors by film title", response = List.class)
    @GetMapping("/actors/title/{title}")
    public List<Acteur> getActorsByTitle(@PathVariable String title) {
        List<Acteur> actorsByTitle = new ArrayList<>();
        for (Film f : films) {
            if (f.getTitle().equals(title)) {
                actorsByTitle.add((Acteur) actors);
            }
        }
        return actorsByTitle;
    }
}
