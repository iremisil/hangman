package my.experiment.hangman.service;

import my.experiment.hangman.model.Game;
import my.experiment.hangman.model.GameStatus;
import my.experiment.hangman.model.Guess;
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

    private Game game;

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

    public Game makeGuess(Long id, Guess guess) {
        game = this.find(id);
        String guessLetter = guess.getGuess();

        if ((game.getGuessesLeft() > 0) && (game.getGameStatus().equals(GameStatus.ONGOING.value()))){
            game.setGuessedWord(quessChecker(guessLetter).toString());
            game.setGuesses(game.getGuesses() + 1);
            game.setGuessesLeft(game.getGuessesLeft() - 1);

            if (game.getGuessesLeft() == 0) {
                game.setGameStatus(GameStatus.LOST.value());
            }
        } else if (game.getGuessedWord().equals(game.getOriginalWord())) {
            game.setGameStatus(GameStatus.WON.value());
        } else {
            game.setGameStatus(GameStatus.LOST.value());
            this.save(game);

        }
        return this.save(game);
    }

    private StringBuilder quessChecker(String guessLetter) {
        StringBuilder stringBuilder = new StringBuilder(game.getGuessedWord());
        String word = game.getOriginalWord();
        System.out.println("word " + word);

        for (int i = 0; i < word.length(); i++) {
            char guessChar = guessLetter.charAt(0);
            if (word.charAt(i) == guessChar) {
                stringBuilder.setCharAt(i, guessChar);
            } else {
                game.setIncorrectLetters(guessLetter);
            }
        }
        return stringBuilder;
    }
}

