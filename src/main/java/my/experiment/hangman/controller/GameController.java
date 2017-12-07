package my.experiment.hangman.controller;

import my.experiment.hangman.exceptions.PlayerNotFoundException;
import my.experiment.hangman.model.Guess;
import my.experiment.hangman.model.Player;
import my.experiment.hangman.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by i00344757 on 06/12/2017.
 */
@RestController
@RequestMapping(value = "/hangman")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.POST, value = "/start")
    public ResponseEntity<Object> startGame(@RequestBody Player player) throws PlayerNotFoundException, IOException {
        return new ResponseEntity<Object>(this.gameService.startGame(player), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findGame/{gameId}")
    public ResponseEntity<Object> fetchGame(@PathVariable String gameId) throws Exception {
        return new ResponseEntity<Object>(this.gameService.find(Long.valueOf(gameId)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAllGame")
    public ResponseEntity fetchAllGame() throws Exception {
        return new ResponseEntity<Object>(this.gameService.listAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{gameId}")
    public ResponseEntity<Object> makeGuess(@PathVariable Long gameId, String guess) {
        return new ResponseEntity<Object>(this.gameService.makeGuess(Long.valueOf(gameId), new Guess(guess)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{gameId}")
    public ResponseEntity<Object> giveUp(@PathVariable Long gameId) {
        return new ResponseEntity<Object>(this.gameService.giveUp(Long.valueOf(gameId)), HttpStatus.OK);
    }
}
