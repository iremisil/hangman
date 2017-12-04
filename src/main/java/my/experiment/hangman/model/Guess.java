package my.experiment.hangman.model;

/**
 * Created by i00344757 on 01/12/2017.
 */

public class Guess {
    private String guess;

    public Guess(String guess) {
        this.setGuess(guess);
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getGuess() {
        return guess;
    }

}
