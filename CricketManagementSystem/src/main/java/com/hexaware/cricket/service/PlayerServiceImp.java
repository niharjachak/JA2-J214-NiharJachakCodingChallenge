package com.hexaware.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exceptions.PlayerNotFoundException;
import com.hexaware.cricket.repository.IPlayerRepository;

@Service
public class PlayerServiceImp  implements IPlayerService{

	
	@Autowired
	IPlayerRepository repo;
	
	
	
	@Override
	public Player addPlayer(Player player) {
		
		return repo.save( player);
	}

	@Override
	public Player updatePlayer(int playerId, Player player) {
	       
		Player existplayer = getPlayerById(playerId);
	        player.setPlayerName(player.getPlayerName());
	        player.setJerseyNumber(player.getJerseyNumber());
	        player.setRole(player.getRole());
	        player.setTotalMatches(player.getTotalMatches());
	        player.setTeamName(player.getTeamName());
	        player.setState(player.getState());
	        player.setDescription(player.getDescription());
	        
	        return repo.save(existplayer);
	    }
	

	@Override
	public Player getPlayerById(int playerId) {
		
		return repo.findById(playerId).orElseThrow(()->new PlayerNotFoundException("Player with Id "+playerId+" not found"));
	}

	@Override
	public String deletePlayerById(int playerId) {
		
		repo.deleteById(playerId);
		
		return "Player deleted SUccesfully";
	}

	@Override
	public List<Player> getAll() {
		
		return repo.findAll();
	}



	
	
	

}
