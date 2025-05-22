package com.devrobattini.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devrobattini.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
