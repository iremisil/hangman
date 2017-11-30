package my.experiment.hangman.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by i00344757 on 30/11/2017.
 */
public class RandomWordGenerator {

    public String generateWord() throws IOException {
        List<String> wordList = getWords();

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(wordList.size());

//        System.out.println("word: " + wordList.get(randomInt));
        return wordList.get(randomInt);
    }

    public List<String> getWords() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("words.txt"));
        String line;
        List<String> wordList = new ArrayList<>();
        while ((line = in.readLine()) != null) {
            wordList.add(line);
        }
        in.close();
        return wordList;
    }
}
