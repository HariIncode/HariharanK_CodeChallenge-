package com.hexaware.cricket_team_managment.entity;

import com.hexaware.cricket_team_managment.model.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "player")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	
	@Column(name = "player_name", nullable = false)
	private String playerName;
	
	@Column(name = "jersey_number", nullable = false)
	private Integer jerseyNumber;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private int matches;
	
	@Column(name = "team_name", nullable = false)
	private String teamName;
	@Column(name = "country_name", nullable = false)
	private String countryState;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
}
