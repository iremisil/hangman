package my.experiment.hangman;

import antlr.debug.GuessingEvent;
import my.experiment.hangman.model.Game;
import my.experiment.hangman.model.Guess;
import my.experiment.hangman.model.Player;
import my.experiment.hangman.service.GameService;
import my.experiment.hangman.service.PlayerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

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
    private Guess guess;

    @Before
    public void setUp() throws Exception {
        player = new Player("isil", 24);
        playerService.save(player);
        //create a new Game
        game = new Game(player);
        gameService.save(game);
        guess = new Guess("i");
    }

    @After
    public void tearDown() {
        gameService.deleteAll();
    }

    @Test
    public void testPlayGame() {
        Game gameplay = gameService.makeGuess(game.getId(), guess);

        assertEquals("Check remaining guess count", 7, gameplay.getGuessesLeft());
        System.out.println("guessWord" + game.getGuessedWord());
        System.out.println("originalWord"+ game.getOriginalWord());


    }
}
