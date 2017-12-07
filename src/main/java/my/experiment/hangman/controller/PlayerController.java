package my.experiment.hangman.controller;

import my.experiment.hangman.model.Player;
import my.experiment.hangman.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by i00344757 on 07/12/2017.
 */
@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> cretaPlayer(@RequestBody Player player) {
        return new ResponseEntity<Object>(this.playerService.save(player), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{playerId}")
    public ResponseEntity<Object> fetchPlayer(@PathVariable Long playerId) {
        return new ResponseEntity<Object>(this.playerService.find(playerId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPlayers")
    public ResponseEntity<Object> fetchAllPlayer() {
        return new ResponseEntity<Object>(this.playerService.listAll(), HttpStatus.OK);
    }

}
