/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.course.buildings;

/**
 *
 * @author RC_Student_lab
 */
public class Building {
    
    private int squareFootage;
    private int stories;

    // Constructor
    public Building(int squareFootage, int stories) {
        this.squareFootage = squareFootage;
        this.stories = stories;
    }

    // Getters and Setters
    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getStories() {
        return stories;
    }

    public void setStories(int stories) {
        this.stories = stories;
    }

    @Override
    public String toString() {
        return "Building [Square Footage: " + squareFootage + ", Stories: " + stories + "]";
    }
}


