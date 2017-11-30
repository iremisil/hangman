package my.experiment.hangman.model;

import javax.persistence.*;

/**
 * Created by i00344757 on 29/11/2017.
 */
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "player")
    private String player;

    //default constructor
    public Game() {

    }

    public Game(Player player) {

        this.setPlayer(player.getName());
    }


    public Long getId() {
        return id;
    }


    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (id != null ? !id.equals(game.id) : game.id != null) return false;
        return player != null ? player.equals(game.player) : game.player == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (player != null ? player.hashCode() : 0);
        return result;
    }
}
