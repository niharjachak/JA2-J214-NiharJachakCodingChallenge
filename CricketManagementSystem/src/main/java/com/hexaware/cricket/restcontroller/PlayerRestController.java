package com.hexaware.cricket.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricket.dto.PlayerDto;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.service.IPlayerService;

@RestController
@RequestMapping("/api/cricket")
public class PlayerRestController {
	
	@Autowired
	IPlayerService service;
	
	
	@PostMapping("/add")
	public Player addPlayer(@RequestBody PlayerDto playerdto) {
		
		
		return service.addPlayer(playerdto);
		
	}
	
	@PutMapping("/update/{playerId}")
	public Player updatePlayer(@PathVariable int playerId , @RequestBody PlayerDto update) {
		
		return  service.updatePlayer(playerId, update);
		
	}
	
	
	@GetMapping("/getplayerbyid/{playerId}")
	public Player getPlayerById( @PathVariable int playerId){
		return service.getPlayerById(playerId);
		
		
	}
	
	
	@DeleteMapping("/deleteplayerbyid/{playerId}")
	public String deletePlayerById(@PathVariable int playerId) {
		
		return service.deletePlayerById(playerId);
	}
	
	
	
	@GetMapping("/getAll")
	public List<Player> getAll(){
		
		return service.getAll();
	}
	
	

}
