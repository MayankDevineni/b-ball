package com.mayank.basketballfantasy.repository;

import com.mayank.basketballfantasy.entity.BasketballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository  extends JpaRepository<BasketballPlayer, Long> {

}
