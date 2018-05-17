package com.example.firebase.testfirebaseapplication;

public class Movie {

    String movie;
    String city;
    String theater;


    public Movie() {

    }

    public Movie(String movie, String city, String theater) {
        this.movie = movie;
        this.city = city;
        this.theater = theater;
    }


    public String getMovie() {
        return movie;
    }

    public String getCity() {
        return city;
    }

    public String getTheater() {
        return theater;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }
}
