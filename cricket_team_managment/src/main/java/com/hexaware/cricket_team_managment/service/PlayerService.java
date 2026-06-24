package com.hexaware.cricket_team_managment.service;

import java.util.List;

import com.hexaware.cricket_team_managment.dto.PlayerDTO;
import com.hexaware.cricket_team_managment.entity.Player;

public interface PlayerService {
	
	Player addPlayer(PlayerDTO dto);
	
	Player updatePlayer(int playerId, PlayerDTO dto);
	
	Player getPlayerById(int playerId);
	
	List<Player> getAllPlayers();
	
	boolean deletePlayer(int playerId);
	
}
