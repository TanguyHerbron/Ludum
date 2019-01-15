package com.ludum.Ludum.repository;

import com.ludum.Ludum.model.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {
}
