package my.experiment.hangman;

import my.experiment.hangman.model.Player;
import my.experiment.hangman.service.PlayerService;
import org.junit.After;
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
@ContextConfiguration(classes = HangmanApplication.class)
@RunWith(SpringRunner.class)
public class PlayerCRUDTest {

    private String name;
    private int age;

    @Autowired
    private PlayerService playerService;

    private Player player;
    private Player persistedEntity;

    @Before
    public void setUp() throws Exception {
        //prepare test data
        name = "isil";
        age = 24;
        player = new Player(name, age);
    }

    @After
    public void tearDown() throws Exception {
        playerService.deleteAll();
    }

    @Test
    public void testPlayerCreation() {

        //assertion
        assertNotNull(player);
        assertEquals("Given name is different than you assigned",name, player.getName());
        assertEquals("Given age is different than you assigned", age, player.getAge());

        //use player service to persist object
        persistedEntity = playerService.save(player);
        System.out.println("player Creation" + player);
        //assert persisted entity if it is identical
        assertNotNull(persistedEntity);
        assertNotNull(persistedEntity.getId());
        assertEquals(player, persistedEntity);

    }

    @Test
    public void testFetchPlayer(){

        persistedEntity = playerService.save(player);
        System.out.println("player fetch" + player);
        persistedEntity = playerService.find(player.getId());
        assertNotNull("player is not created",persistedEntity);
        assertEquals("Fetch player information. ",player, persistedEntity);

    }

}
