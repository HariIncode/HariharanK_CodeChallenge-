package com.hexaware.cricket_team_managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.cricket_team_managment.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
