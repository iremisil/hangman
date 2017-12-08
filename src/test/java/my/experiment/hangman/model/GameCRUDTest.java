package my.experiment.hangman.model;

import my.experiment.hangman.HangmanApplication;
import my.experiment.hangman.exceptions.PlayerNotFoundException;
import my.experiment.hangman.model.Game;
import my.experiment.hangman.model.GameStatus;
import my.experiment.hangman.model.Player;
import my.experiment.hangman.service.GameService;
import my.experiment.hangman.service.PlayerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by i00344757 on 29/11/2017.
 */
@SpringBootTest
@ContextConfiguration(classes = HangmanApplication.class)
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GameCRUDTest {


    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    private Player player;
    private Game game;

    @Before
    public void setUp() throws Exception {
        player = new Player("isil", 24);
        playerService.save(player);
        //create a new Game
        game = new Game(player);
    }

    @After
    public void tearDown() throws Exception {
        gameService.deleteAll();
        playerService.deleteAll();
    }

    @Test
    public void testGameCreation() {

        //save game to the Service
        gameService.save(game);

        assertNotNull("Game can not be created", game.getId());
        assertEquals("Game player is not matched", player.getName(), game.getPlayer());
        assertTrue("There is not any word guessed", game.getGuessedWord() != null);
        assertEquals("the number of guesses left should be 8", 8, game.getGuessesLeft());
        assertTrue("", StringUtils.isEmpty(game.getIncorrectLetters()));
        assertEquals(GameStatus.ONGOING.value(), game.getGameStatus());
//        assertNotNull("Indicates the number of guesses made",game.getQuesses());

    }

    @Test
    public void testFetchGame() {

        gameService.save(game);

        assertNotNull("Game could not found ", game.getId());

        //fetches game information
        Game persistedGame = gameService.find(game.getId());
        assertEquals("Games are not persisted", game, persistedGame);

    }

    @Test
    public void testFetchAllGame() {

        Game persistedgame = gameService.save(game);

        //fetches all the games
        List<Game> gamesArrayList = gameService.listAll();
        assertEquals("Games are not identical ", persistedgame, gamesArrayList.get(0));
    }
}
