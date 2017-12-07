package my.experiment.hangman.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by i00344757 on 07/12/2017.
 */
public class GameNotFoundException extends Exception {
    private static final Logger LOGGER = Logger.getLogger(GameNotFoundException.class.getName());

    public GameNotFoundException(Long id) {

        LOGGER.log(Level.SEVERE, "Game not found! ", id);
    }
}
