package my.experiment.hangman;

import org.h2.util.StringUtils;
import my.experiment.hangman.util.RandomWordGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by i00344757 on 30/11/2017.
 */
@SpringBootTest
@ContextConfiguration(classes = HangmanApplication.class)
@RunWith(SpringRunner.class)
public class RandomWordGeneratorTest {

    @Test
    public void testRandomWordGenerator() throws IOException {
        RandomWordGenerator randomWordGenerator = new RandomWordGenerator();
        String word = randomWordGenerator.generateWord();

        assertFalse(StringUtils.isNullOrEmpty(word));
    }
}
