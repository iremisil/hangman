package my.experiment.hangman;

import my.experiment.hangman.model.Player;
import my.experiment.hangman.service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by i00344757 on 28/11/2017.
 */
@SpringBootTest
@ContextConfiguration(classes = PlayerApplication.class)
@RunWith(SpringRunner.class)
public class PlayerCRUDTest {

    private String name;
    private int age;

    @Autowired
    private PlayerService playerService;

    @Before
    public void setUp() throws Exception {
        //prepare test data
        name = "isil";
        age = 24;
    }

    @Test
    public void testPlayerCreation() {
        //action
        Player player = new Player(name, age);
        //assertion
        assertNotNull(player);
        assertEquals(name, player.getName());
        assertEquals("Given age is different than you assigned", age, player.getAge());

        //use player service to persist object
        Player persistedEntity = playerService.save(player);
        //assert persisted entity if it is identical
        assertNotNull(persistedEntity);
        assertNotNull(persistedEntity.getId());
        assertEquals(player, persistedEntity);

    }

}
