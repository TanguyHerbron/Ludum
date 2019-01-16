package com.ludum.Ludum.matchmaking;

import com.ludum.Ludum.model.Game;
import com.ludum.Ludum.model.Match;
import com.ludum.Ludum.model.Team;
import com.ludum.Ludum.model.Tournament;
import com.ludum.Ludum.repository.GameRepository;
import com.ludum.Ludum.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatchMaker {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private GameRepository gameRepository;

    private List<Team> teamList;
    private Tournament tournament;

    public MatchMaker(Tournament tournament, List<Team> teamList)
    {
        this.tournament = tournament;
        this.teamList = teamList;
    }

    public void build()
    {
        for(int i = 0; i < teamList.size(); i++)
        {
            for(int j = i + 1; j < teamList.size(); j++)
            {
                Match newMatch = new Match();
                newMatch.setIdMatch(matchRepository.count() + 1);
                newMatch.setIdTournament(tournament.getId());
                newMatch.setLocation("Somewhere");

                Game game1 = new Game();
                game1.setIdMatch(newMatch.getIdMatch());
                game1.setIdTeam(teamList.get(i).getId());

                Game game2 = new Game();
                game2.setIdMatch(newMatch.getIdMatch());
                game2.setIdTeam(teamList.get(j).getId());

                gameRepository.save(game1);
                gameRepository.save(game2);

                matchRepository.save(newMatch);
            }
        }
    }
}
