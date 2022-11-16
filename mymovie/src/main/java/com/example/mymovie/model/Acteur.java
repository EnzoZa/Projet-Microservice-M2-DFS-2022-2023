package com.example.mymovie.model;

import io.swagger.annotations.ApiModelProperty;

//créer un object acteur qui un nom, prénom date de naissance et un filmographie
public class Acteur {
    @ApiModelProperty(notes = "First name of the actor",name="firstName",required=true,value="test first name")
    private String firstName;
    @ApiModelProperty(notes = "Last name of the actor",name="lastName",required=true,value="test last name")
    private String lastName;
    @ApiModelProperty(notes = "Birth date of the actor",name="birthDate",required=true,value="test birth date")
    private String birthDate;
    @ApiModelProperty(notes = "Filmography of the actor",name="filmography",required=true,value="test filmography")
    private String filmography;

    public Acteur(String firstName, String lastName, String birthDate, String filmography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.filmography = filmography;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getFilmography() {
        return filmography;
    }

    //La filmographie d’un acteur vient de l’objet film
    public void setFilmography(Film film) {
        this.filmography = film.getTitle() + " " + film.getReleaseDate();
    }
}
