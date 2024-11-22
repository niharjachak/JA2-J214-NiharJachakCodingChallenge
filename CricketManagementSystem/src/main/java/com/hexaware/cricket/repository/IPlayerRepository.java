package com.hexaware.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.cricket.entity.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player , Integer> {
	
	

}

