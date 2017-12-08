package my.experiment.hangman;

import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by i00344757 on 08/12/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest(classes = HangmanApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SpringIntegration {

    @LocalServerPort
    protected int randomServerPort;

}
