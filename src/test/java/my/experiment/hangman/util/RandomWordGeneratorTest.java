package my.experiment.hangman.util;

import my.experiment.hangman.HangmanApplication;
import org.h2.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertFalse;

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
