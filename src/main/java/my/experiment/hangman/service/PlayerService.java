package my.experiment.hangman.service;

import my.experiment.hangman.exceptions.PlayerNotFoundException;
import my.experiment.hangman.model.Player;
import my.experiment.hangman.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by i00344757 on 28/11/2017.
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public Player find(Long id) throws PlayerNotFoundException {
        Player player = playerRepository.findOne(id);

        if (null != player) {
            return player;
        } else {
            throw new PlayerNotFoundException(id);
        }
    }

    public void deleteAll() {
        playerRepository.deleteAll();
    }

    public List<Player> listAll() {
        return playerRepository.findAll();
    }

    public boolean exists(Long id) {
        return playerRepository.exists(id);
    }
}
