package com.hexaware.cricket_team_managment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricket_team_managment.dto.PlayerDTO;
import com.hexaware.cricket_team_managment.entity.Player;
import com.hexaware.cricket_team_managment.exception.PlayerException;
import com.hexaware.cricket_team_managment.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	PlayerRepository repo;

	@Override
	public Player addPlayer(PlayerDTO dto) {
		Player player = new Player();
		mapDTOToEntity(player, dto);
		return repo.save(player);
	}

	@Override
	public Player updatePlayer(int playerId, PlayerDTO dto) {
		Player player = getPlayerById(playerId);
		mapDTOToEntity(player, dto);
		return repo.save(player);
	}

	@Override
	public Player getPlayerById(int playerId) {
		return repo.findById(playerId).orElseThrow(() -> new PlayerException("Player With the given Id not found: " + playerId));
	}

	@Override
	public List<Player> getAllPlayers() {
		return repo.findAll();
	}

	@Override
	public boolean deletePlayer(int playerId) {
		Player player = getPlayerById(playerId);
		repo.delete(player);
		return true;
	}
	
	private void mapDTOToEntity(Player player, PlayerDTO dto) {
		player.setPlayerName(dto.getPlayerName());
		player.setDescription(dto.getDescription());
		player.setRole(dto.getRole());
		player.setJerseyNumber(dto.getJerseyNumber());
		player.setTeamName(dto.getTeamName());
		player.setCountryState(dto.getCountryState());
		player.setMatches(dto.getMatches());
	}

}
