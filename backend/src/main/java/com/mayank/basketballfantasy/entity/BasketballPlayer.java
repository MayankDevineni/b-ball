package com.mayank.basketballfantasy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class BasketballPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String team;
    private String position;            
    private double pointsPerGame;
    private double reboundsPerGame; 
    private double assistsPerGame;

    //  default Constructors
    public BasketballPlayer(){

    }

    // CONSTRUCTOR WITH PARAMETERS (for creating players)

    public BasketballPlayer(String name, String team, String position, double pointsPerGame, double reboundsPerGame, double assistsPerGame) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.pointsPerGame = pointsPerGame;
        this.reboundsPerGame = reboundsPerGame;
        this.assistsPerGame = assistsPerGame;


    }
}
