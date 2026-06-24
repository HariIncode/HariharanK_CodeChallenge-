package com.hexaware.cricket_team_managment.dto;

import com.hexaware.cricket_team_managment.model.Role;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlayerDTO {

	private int playerId;

	@NotBlank(message = "Player Name Required")
	@Size(min = 3, max = 26, message = "Enter a Valid Name.")
	private String playerName;

	@NotNull(message = "Jersey Number Required between 1 to 100")
	@Min(value = 1, message = "Minimum value for Jersey number is 1")
	@Max(value = 100, message = "Maximum value for Jersey number is 100")
	private Integer jerseyNumber;

	@NotNull(message = "Role must be Specified")
	private Role role;

	@PositiveOrZero
	private int matches;

	@NotBlank
	@Size(min = 6, max = 50, message = "Team name should be between 6 and 50 characters")
	private String teamName;

	@NotBlank(message = "Country and State Required")
	@Size(min = 10, message = "CountryName and StateName should be seperated with '/'")
	private String countryState;

	@NotBlank(message = "Description Required")
	@Size(min = 15, max = 255, message = "Field Limit Exceeds.")
	private String description;

}
