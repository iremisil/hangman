package my.experiment.hangman;

import my.experiment.hangman.model.Game;
import my.experiment.hangman.model.Player;
import my.experiment.hangman.service.GameService;
import my.experiment.hangman.service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by i00344757 on 30/11/2017.
 */
@SpringBootTest
@ContextConfiguration(classes = HangmanApplication.class)
@RunWith(SpringRunner.class)
public class PlayGameTest {

    @Autowired
    PlayerService playerService;

    @Autowired
    GameService gameService;

    private Game game;
    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("isil", 24);
        playerService.save(player);
        //create a new Game
        game = new Game(player);
    }

    @Test
    public void testPlayGame() {
        gameService.save(game);

    }
}
