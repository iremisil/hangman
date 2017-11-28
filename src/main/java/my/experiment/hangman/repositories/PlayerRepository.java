package my.experiment.hangman.repositories;

import my.experiment.hangman.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by i00344757 on 28/11/2017.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
