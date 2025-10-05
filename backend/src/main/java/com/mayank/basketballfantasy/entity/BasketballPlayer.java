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

    // DEFAULT CONSTRUCTOR
    public BasketballPlayer() {
    }

    // CONSTRUCTOR WITH PARAMETERS
    public BasketballPlayer(String name, String team, String position, 
                          double pointsPerGame, double reboundsPerGame, double assistsPerGame) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.pointsPerGame = pointsPerGame;
        this.reboundsPerGame = reboundsPerGame;
        this.assistsPerGame = assistsPerGame;
    }

    // GETTERS AND SETTERS (OUTSIDE CONSTRUCTOR!)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }
    
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    
    public double getPointsPerGame() { return pointsPerGame; }
    public void setPointsPerGame(double pointsPerGame) { this.pointsPerGame = pointsPerGame; }
    
    public double getReboundsPerGame() { return reboundsPerGame; }
    public void setReboundsPerGame(double reboundsPerGame) { this.reboundsPerGame = reboundsPerGame; }
    
    public double getAssistsPerGame() { return assistsPerGame; }
    public void setAssistsPerGame(double assistsPerGame) { this.assistsPerGame = assistsPerGame; }
}