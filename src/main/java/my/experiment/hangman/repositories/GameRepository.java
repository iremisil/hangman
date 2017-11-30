package my.experiment.hangman.repositories;

import my.experiment.hangman.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by i00344757 on 29/11/2017.
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
