/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.course.buildings;

/**
 *
 * @author RC_Student_lab
 */
public class CreateBuildings {
    public static void main(String[] args) {
        // Create a Building object
        Building building = new Building(5000, 3);
        System.out.println(building);

        // Create a House object
        House house = new House(2000, 2, 4, 3);
        System.out.println(house);

        // Create a School object
        Schoool school = new Schoool(10000, 4, 20, "Elementary");
        System.out.println(school);
    }
}


