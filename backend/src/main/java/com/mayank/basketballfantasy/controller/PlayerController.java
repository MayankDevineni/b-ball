package com.mayank.basketballfantasy.controller;

import com.mayank.basketballfantasy.entity.BasketballPlayer;
import com.mayank.basketballfantasy.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<BasketballPlayer> getAllPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    public BasketballPlayer createPlayer(@RequestBody BasketballPlayer player) {
        return playerRepository.save(player);      
    }

    @GetMapping("/players/count")
    public long getPlayerCount() {
        return playerRepository.count();
    }
}