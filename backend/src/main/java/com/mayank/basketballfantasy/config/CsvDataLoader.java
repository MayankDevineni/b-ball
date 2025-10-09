package com.mayank.basketballfantasy.config;

import com.mayank.basketballfantasy.entity.BasketballPlayer;
import com.mayank.basketballfantasy.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class CsvDataLoader {

    @Autowired
    private PlayerRepository playerRepository;

    @PostConstruct
    public void loadPlayerData() {
        System.out.println(" CSV Data Loader STARTING...");
        System.out.println(" Current player count: " + playerRepository.count());

        try {
            if (playerRepository.count() == 0) {
                System.out.println(" Database is EMPTY - Loading NBA players from CSV...");

                ClassPathResource resource = new ClassPathResource("nba_players.csv");
                System.out.println(" CSV file exists: " + resource.exists());

                BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

                String line;
                boolean isFirstLine = true;
                int playersLoaded = 0;

                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) {
                        System.out.println(" CSV Header: " + line);
                        isFirstLine = false;
                        continue;
                    }

                    String[] data = line.split(",");
                    System.out.println("🔍 Parsing line " + (playersLoaded + 1) + ": " + data.length + " columns");

                    // Check for minimum columns (should be 30)
                   if (data.length >= 30) {
                    String name = data[1].trim();
                    String position = data[2].trim();
                    String team = data[4].trim(); // Tm is at index 4

                    double points = parseDoubleSafe(data[29]);   // PTS is at 29
                    double rebounds = parseDoubleSafe(data[25]); // TRB is at 25
                    double assists = parseDoubleSafe(data[26]);  // AST is at 26

                    BasketballPlayer player = new BasketballPlayer(name, team, position, points, rebounds, assists);
                    playerRepository.save(player);
                    playersLoaded++;

                    if (playersLoaded <= 5) {
                        System.out.println(" Added: " + name + " - " + team + " - " + position);
                    }
                } else {
                        System.out.println(" Skipping line - only " + data.length + " columns (need 30)");
                    }
                }

                reader.close();

                System.out.println(" SUCCESS! Loaded " + playersLoaded + " NBA players from CSV!");
            } else {
                System.out.println(" Database already has " + playerRepository.count() + " players. Skipping CSV load.");
            }
        } catch (Exception e) {
            System.out.println(" Error loading CSV data: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println(" CSV Data Loader FINISHED");
    }

    private double parseDoubleSafe(String value) {
        try {
            return Double.parseDouble(value.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }
}