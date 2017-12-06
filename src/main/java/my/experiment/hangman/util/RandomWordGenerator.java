package my.experiment.hangman.util;

import my.experiment.hangman.model.Guess;

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

    public Guess randomLetterGenerator() {
        Random random = new Random();
        char charAt = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        charAt = alphabet.charAt(random.nextInt(alphabet.length()));

        return new Guess(String.valueOf(charAt));
    }
}
