package com.ludum.Ludum.repository;

import com.ludum.Ludum.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}
