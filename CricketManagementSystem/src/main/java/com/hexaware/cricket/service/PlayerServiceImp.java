package com.hexaware.cricket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricket.dto.PlayerDto;
import com.hexaware.cricket.entity.Player;
import com.hexaware.cricket.exceptions.PlayerNotFoundException;
import com.hexaware.cricket.repository.IPlayerRepository;

@Service
public class PlayerServiceImp  implements IPlayerService{

	
	@Autowired
	IPlayerRepository repo;
	
	
	
	@Override
	public Player addPlayer(PlayerDto playerdto) {
		
		Player player = new Player();
		player.setPlayerName(playerdto.getPlayerName());
		player.setJerseyNumber(playerdto.getJerseyNumber());
		player.setRole(playerdto.getRole());
		player.setTotalMatches(playerdto.getTotalMatches());
		player.setTeamName(playerdto.getTeamName());
		player.setState(playerdto.getState());
		player.setDescription(playerdto.getDescription());
		
		return repo.save( player);
	}

	@Override
	public Player updatePlayer(int playerId, PlayerDto player) {
	       
		Player existplayer = getPlayerById(playerId);
	        existplayer.setPlayerName(player.getPlayerName());
	        existplayer.setJerseyNumber(player.getJerseyNumber());
	        existplayer.setRole(player.getRole());
	        existplayer.setTotalMatches(player.getTotalMatches());
	        existplayer.setTeamName(player.getTeamName());
	        existplayer.setState(player.getState());
	        existplayer.setDescription(player.getDescription());
	        
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
