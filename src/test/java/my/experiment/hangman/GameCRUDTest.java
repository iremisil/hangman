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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by i00344757 on 29/11/2017.
 */
@SpringBootTest
@ContextConfiguration(classes = HangmanApplication.class)
@RunWith(SpringRunner.class)
public class GameCRUDTest {


    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("isil", 24);
        playerService.save(player);
    }

    @Test
    public void testGameCreation() {

        //create new Game
        Game game = new Game(player);
        gameService.save(game);

        assertNotNull("Game can not be created", game.getId());
        assertEquals("Game player is not matched", player.getName(), game.getPlayer());
//        assertNotNull("Indicates the number of guesses made",game.getQuesses());

    }

    @Test
    public void testFetchGame() {
        Game game = new Game(player);
        gameService.save(game);

        assertNotNull("Game could not found ", game.getId());

        //fetches game information
        gameService.find(game.getId());

    }

    @Test
    public void testFetchAllGame() {
        Game game = new Game(player);
        gameService.save(game);

        //fetches all the games
        List<Game> gamesArrayList = gameService.listAll();
        assertEquals(game, gamesArrayList.get(0));
    }
}
