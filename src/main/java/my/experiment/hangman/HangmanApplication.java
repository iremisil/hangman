package my.experiment.hangman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by i00344757 on 28/11/2017.
 */
@EnableAutoConfiguration
@ComponentScan("my.experiment.hangman")
public class HangmanApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HangmanApplication.class, args);
    }
}
