package my.experiment.hangman.service;

import my.experiment.hangman.model.Game;
import my.experiment.hangman.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by i00344757 on 29/11/2017.
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public Game find(Long id) {
        return gameRepository.findOne(id);
    }

    public List<Game> listAll() {
        return gameRepository.findAll();
    }

    public void deleteAll() {
        gameRepository.deleteAll();
    }
}
