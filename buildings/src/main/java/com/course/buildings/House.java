/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.course.buildings;

/**
 *
 * @author RC_Student_lab
 */
public class House extends Building {
    
    private int bedrooms;
    private int baths;

    // Constructor
    public House(int squareFootage, int stories, int bedrooms, int baths) {
        super(squareFootage, stories);
        this.bedrooms = bedrooms;
        this.baths = baths;
    }

    // Getters and Setters
    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    @Override
    public String toString() {
        return "House [Square Footage: " + getSquareFootage() + ", Stories: " + getStories() +
                ", Bedrooms: " + bedrooms + ", Baths: " + baths + "]";
    }
}


