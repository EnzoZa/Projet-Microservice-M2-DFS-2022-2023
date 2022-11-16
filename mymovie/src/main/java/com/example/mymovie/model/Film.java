package com.example.mymovie.model;

import io.swagger.annotations.ApiModelProperty;

//créer un objet film qui a un titre, réalisateur, acteur principal et date de sortie
public class Film {
    @ApiModelProperty(notes = "Title of the movie",name="title",required=true,value="test title")
    private String title;
    @ApiModelProperty(notes = "Director of the movie",name="director",required=true,value="test director")
    private String director;
    @ApiModelProperty(notes = "Main actor of the movie",name="mainActor",required=true,value="test main actor")
    private String mainActor;
    @ApiModelProperty(notes = "Release date of the movie",name="releaseDate",required=true,value="test release date")
    private String releaseDate;

    public Film(String title, String director, String mainActor, String releaseDate) {
        this.title = title;
        this.director = director;
        this.mainActor = mainActor;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getMainActor() {
        return mainActor;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    //L’acteur principal dans l’objet film est l’objet acteur
    public void setMainActor(Acteur mainActor) {
        this.mainActor = mainActor.getFirstName() + " " + mainActor.getLastName();
    }

}
