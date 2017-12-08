package my.experiment.hangman;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by i00344757 on 08/12/2017.
 */

@ContextConfiguration
@SpringBootTest(classes = HangmanApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SpringIntegration {

    @LocalServerPort
    protected int randomServerPort;

}
