package com.datastructure.javaproject.problemsolving;

import java.util.ArrayList;
import java.util.Collections;

class Movie implements Comparable<Movie> {
    private String n; // Movie Name
    private double r; // Movie Rating
    private int y; // Release year of the movie

    // Constructor 
    public Movie(String n, double r, int y) {
        this.n = n;
        this.r = r;
        this.y = y;
    }

    // Implementation of the compareTo method 
    // for default sorting by year
    public int compareTo(Movie m) {
      
        // Sort movies in ascending 
        // order of year
        return this.y - m.y; 
    }

    // Getter and Setter method 
    public String getName() {
        return n;
    }

    public double getRating() {
        return r;
    }

    public int getYear() {
        return y;
    }
}

public class MovieClass {
    public static void main(String[] args) {
      
        // Create a list of movies
        ArrayList<Movie> l = new ArrayList<>();
        l.add(new Movie("Star Wars", 8.7, 1977));
        l.add(new Movie("Empire Strikes Back", 8.8, 1980));
        l.add(new Movie("Return of the Jedi", 8.4, 1983));

        // Sort movies using Comparable's 
        // compareTo method by year
        Collections.sort(l);

        // Display the sorted list of movies
        System.out.println("Movies after sorting by year:");
        for (Movie m : l) {
          
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
    }
}
