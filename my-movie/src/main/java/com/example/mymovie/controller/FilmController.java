package com.example.mymovie.controller;
import com.example.mymovie.model.Acteur;
import com.example.mymovie.model.Film;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {
    private List<Film> films = new ArrayList<>();
    private List<Acteur> actors = new ArrayList<>();


    {
        actors.add(new Acteur("Marlon", "Brando", "1924", ""));
        actors.add(new Acteur("Tim", "Robbins", "1958", ""));
        actors.add(new Acteur("Christian", "Bale", "1974", ""));

        films.add(new Film("The_Godfather", "Francis Ford Coppola", actors.get(0), "1972"));
        films.add(new Film("The Shawshank Redemption", "Frank Darabont", actors.get(1), "1994"));
        films.add(new Film("The Dark Knight", "Christopher Nolan", actors.get(2), "2008"));
    }

    @ApiOperation(value = "Get all films", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })


    @GetMapping("/films")
    public List<Film> getFilms() {
        return films;
    }

    //récupérer les films selon le titre
    @ApiOperation(value = "Get films by title", response = List.class)
    @GetMapping("/films/title/{title}")
    public Film getFilmsByTitle(@PathVariable String title) {
        Film film = new Film("", "", new Acteur("","","",""), "");
        for (Film f : films) {
            if (f.getTitle().equals(title)) {
                film = f;
            }
        }
        return film;
    }

    //récupérer les films selon l’année de sortie
    @ApiOperation(value = "Get films by year", response = List.class)
    @GetMapping("/films/releaseDate/{releaseDate}")
    public List<Film> getFilmsByReleaseDate(@PathVariable String releaseDate) {
        List<Film> filmsByReleaseDate = new ArrayList<>();
        for (Film f : films) {
            if (f.getReleaseDate().equals(releaseDate)) {
                filmsByReleaseDate.add(f);
            }
        }
        return filmsByReleaseDate;
    }

    //update
    @ApiOperation(value = "Update a film", response = List.class)
    @PutMapping("/films/put/{title}")
    public Film updateFilm(@PathVariable String title, @RequestBody Film film) {
        for (Film f : films) {
            if (f.getTitle().equals(title)) {
                f.setTitle(film.getTitle());
                f.setDirector(film.getDirector());
                f.setMainActor(film.getMainActor());
                f.setReleaseDate(film.getReleaseDate());
            }
        }
        return film;
    }

    //delete
    @ApiOperation(value = "Delete a film", response = List.class)
    @DeleteMapping("/films/delete/{title}")
    public Film deleteFilm(@PathVariable String title) {
        Film film = new Film("", "", new Acteur("", "", "", ""), "");
        for (Film f : films) {
            if (f.getTitle().equals(title)) {
                film = f;
                films.remove(f);
            }
        }
        return film;
    }
}
