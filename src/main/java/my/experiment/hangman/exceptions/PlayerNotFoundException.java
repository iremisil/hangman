package my.experiment.hangman.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by i00344757 on 06/12/2017.
 */
public class PlayerNotFoundException extends Exception {

    private static final Logger LOGGER = Logger.getLogger(PlayerNotFoundException.class.getName());

    public PlayerNotFoundException(Long id) {

        LOGGER.log(Level.SEVERE, "Player not found! ", id);
    }
}
