/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.course.buildings;

/**
 *
 * @author RC_Student_lab
 */
    public class Schoool extends Building {
    private int classrooms;
    private String gradeLevel;

    // Constructor
    public Schoool(int squareFootage, int stories, int classrooms, String gradeLevel) {
        super(squareFootage, stories);
        this.classrooms = classrooms;
        this.gradeLevel = gradeLevel;
    }

    // Getters and Setters
    public int getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(int classrooms) {
        this.classrooms = classrooms;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public String toString() {
        return "School [Square Footage: " + getSquareFootage() + ", Stories: " + getStories() +
                ", Classrooms: " + classrooms + ", Grade Level: " + gradeLevel + "]";
    }
}


