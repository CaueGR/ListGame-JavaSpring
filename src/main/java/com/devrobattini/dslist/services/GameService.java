package com.devrobattini.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devrobattini.dslist.dto.GameMinDTO;
import com.devrobattini.dslist.entities.Game;
import com.devrobattini.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(GameMinDTO::new).toList();
		
	}
	
}
