package my.experiment.hangman.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import my.experiment.hangman.util.RandomWordGenerator;

import javax.persistence.*;
import java.io.IOException;

/**
 * Created by i00344757 on 29/11/2017.
 */
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "player")
    private String player;

    @JsonIgnore
    @Column(name = "guessedWord")
    private String guessedWord;

    @Column(name = "guessesLeft")
    private int guessesLeft;

    @Column(name = "guesses")
    private int guesses;

    @Column(name = "incorrectLetters")
    private String incorrectLetters;

    @JsonIgnore
    @Column(name = "originalWord")
    private String originalWord;

    @Column(name = "gameStatus")
    private String gameStatus;
    private String word;


    //default constructor
    public Game() {

    }

    public Game(Player player) throws IOException {
        RandomWordGenerator generator = new RandomWordGenerator();
        String generatedWord = generator.generateWord();

        this.setPlayer(player.getName());
        this.setOriginalWord(generatedWord);
        this.setGuessedWord(generatedWord);
        this.setGuessesLeft(8);
        this.setGameStatus(GameStatus.ONGOING.value());
        this.setGuesses(0);
        this.setGuessedWord(this.getGuessedWord().replaceAll("(?s).", "*"));

    }


    public Long getId() {
        return id;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public Object getIncorrectLetters() {
        return incorrectLetters;
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    public void setGuessedWord(String guessedWord) {
        this.guessedWord = guessedWord;
    }

    public void setGuessesLeft(int guessesLeft) {
        this.guessesLeft = guessesLeft;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public void setIncorrectLetters(String incorrectLetters) {
        this.incorrectLetters = incorrectLetters;
    }

    public int getGuesses() {
        return guesses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (guessesLeft != game.guessesLeft) return false;
        if (guesses != game.guesses) return false;
        if (id != null ? !id.equals(game.id) : game.id != null) return false;
        if (player != null ? !player.equals(game.player) : game.player != null) return false;
        if (guessedWord != null ? !guessedWord.equals(game.guessedWord) : game.guessedWord != null) return false;
        if (incorrectLetters != null ? !incorrectLetters.equals(game.incorrectLetters) : game.incorrectLetters != null)
            return false;
        if (originalWord != null ? !originalWord.equals(game.originalWord) : game.originalWord != null) return false;
        return gameStatus == game.gameStatus;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (player != null ? player.hashCode() : 0);
        result = 31 * result + (guessedWord != null ? guessedWord.hashCode() : 0);
        result = 31 * result + guessesLeft;
        result = 31 * result + guesses;
        result = 31 * result + (incorrectLetters != null ? incorrectLetters.hashCode() : 0);
        result = 31 * result + (originalWord != null ? originalWord.hashCode() : 0);
        result = 31 * result + (gameStatus != null ? gameStatus.hashCode() : 0);
        return result;
    }
}
