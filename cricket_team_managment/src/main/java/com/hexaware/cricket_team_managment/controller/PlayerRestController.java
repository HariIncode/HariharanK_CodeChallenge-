package com.hexaware.cricket_team_managment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricket_team_managment.dto.PlayerDTO;
import com.hexaware.cricket_team_managment.entity.Player;
import com.hexaware.cricket_team_managment.service.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PlayerRestController {
	
	@Autowired
	PlayerService service;
	
	@PostMapping("/players")
	public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addPlayer(dto));
	}
	
	@PutMapping("/players/{playerId}")
	public ResponseEntity<Player> updatePlayer(@PathVariable int playerId, @RequestBody @Valid PlayerDTO dto){
		return ResponseEntity.status(HttpStatus.OK).body(service.updatePlayer(playerId ,dto));
	}
	
	@GetMapping("/players")
	public ResponseEntity<List<Player>> getAllPlayers(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllPlayers());
	}
	
	@GetMapping("/players/{playerId}")
	public ResponseEntity<Player> getPlayerById(@PathVariable int playerId){
		return ResponseEntity.status(HttpStatus.OK).body(service.getPlayerById(playerId));
	}
	
	@DeleteMapping("/players/{playerId}")
	public ResponseEntity<String> deletePlayer(@PathVariable int playerId){
		if(service.deletePlayer(playerId)) {
			return ResponseEntity.status(HttpStatus.OK).body("Player Deleted SuccessFully.");			
		}
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Some Internal Error!");			
		
	}
}
