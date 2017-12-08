package my.experiment.hangman;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by i00344757 on 08/12/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty"}, features = "src/test/resources/features", strict = true)
@ActiveProfiles(value = "test")
public class BDDTest {
}
