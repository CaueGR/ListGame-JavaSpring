package com.devrobattini.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devrobattini.dslist.dto.GameListDTO;
import com.devrobattini.dslist.entities.GameList;
import com.devrobattini.dslist.projections.GameMinProjections;
import com.devrobattini.dslist.repositories.GameListRepository;
import com.devrobattini.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(GameListDTO::new).toList();
		
	}
	
	public void move(Long listId, int sourceIndex, int DestinationIndex) {
		List<GameMinProjections> list = gameRepository.searchByList(listId);
		
		GameMinProjections obj = list.remove(sourceIndex);
		list.add(DestinationIndex, obj);
		
		int min = sourceIndex < DestinationIndex ? sourceIndex : DestinationIndex;
		int max = sourceIndex < DestinationIndex ? DestinationIndex : sourceIndex;
		
		for(int i =min; i<=max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
	
}
