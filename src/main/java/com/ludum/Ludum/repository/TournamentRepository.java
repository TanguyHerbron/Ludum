package com.ludum.Ludum.repository;

import com.ludum.Ludum.model.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
}
