package my.experiment.hangman;

import my.experiment.hangman.model.Game;
import my.experiment.hangman.model.GameStatus;
import my.experiment.hangman.model.Guess;
import my.experiment.hangman.model.Player;
import my.experiment.hangman.service.GameService;
import my.experiment.hangman.service.PlayerService;
import my.experiment.hangman.util.RandomWordGenerator;
import org.h2.util.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    private RandomWordGenerator generator;

    @Before
    public void setUp() throws Exception {
        player = new Player("isil", 24);
        playerService.save(player);
        //create a new Game
        game = new Game(player);
        gameService.save(game);
        guess = new Guess("i");
        generator = new RandomWordGenerator();
    }

    @After
    public void tearDown() {
        gameService.deleteAll();
    }

    @Test
    public void testPlayGame() {
        Game gameplay = gameService.makeGuess(game.getId(), guess);

        assertEquals("Check remaining guess count", 7, gameplay.getGuessesLeft());

        if (gameplay.getGuessedWord().contains(guess.getGuess())) {
            assertTrue("Guess letter is not contained", (gameplay.getIncorrectLetters() != null));
        } else {
            assertTrue("Incorrect letter not contained guessed letter", gameplay.getIncorrectLetters().contains(guess.getGuess()));
        }

        assertEquals("Guessing count is not equal 1", 1, gameplay.getGuesses());
    }

    @Test
    public void testGuessOver() {

        for (int i = 0; i < 8; i++) {
            guess = generator.randomLetterGenerator();
            gameService.makeGuess(this.game.getId(), guess);
        }
    }

    @Test
    public void TestGiveUp() {
        //allows you to give up on a game. It ends the game and returns the game object with word revealed

        Game tempGame = gameService.giveUp(game.getId());

        assertEquals("Status is not LOST", GameStatus.LOST.value(), tempGame.getGameStatus());
        assertEquals("Guessed word is not same", game.getGuessedWord(), tempGame.getGuessedWord());
    }
}
