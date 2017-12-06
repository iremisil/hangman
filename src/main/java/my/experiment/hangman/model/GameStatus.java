package my.experiment.hangman.model;

/**
 * Created by i00344757 on 30/11/2017.
 */
public enum GameStatus {

    // Contains the state of the game
    ONGOING("ongoing"), WON("won"), LOST("lost");

    private String value;

    GameStatus(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
