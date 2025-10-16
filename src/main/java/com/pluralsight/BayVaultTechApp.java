package com.pluralsight;
//BayVaultTechApp – Starts the program
import java.awt.*;

public class BayVaultTechApp {
    public static void main(String[] args) {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.showMenu();
    }
}
//Notes for presentation:
//1.this is basically my "Start Screen"
//2.it creates the start screen & shows the menu
//3.try to think about as: it turns on your menu screen so everything else can happen after