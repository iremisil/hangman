package my.experiment.hangman.cucumber;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.experiment.hangman.SpringIntegration;
import my.experiment.hangman.model.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


/**
 * Created by i00344757 on 08/12/2017.
 */
public class PlayerCreateTest extends SpringIntegration {

    private Player player;

    private RestTemplate restTemplate;

    private ResponseEntity<Player> responseEntity;


    public PlayerCreateTest() {
        restTemplate = new RestTemplate();
    }

    @Given("^Player informations$")
    public void player_informations(DataTable dataTable) throws Throwable {
        player = dataTable.asList(Player.class).get(0);
    }

    @When("^perform POST request to \"([^\"]*)\"$")
    public void perform_POST_request_to(String rest) throws Throwable {
        responseEntity = restTemplate.postForEntity("http://localhost:" + randomServerPort + "/" + rest, player, Player.class);
    }

    @Then("^after create player all players should have id$")
    public void after_create_player_all_players_should_have_id() throws Throwable {
        assertThat(responseEntity.getBody().getId(), is(notNullValue()));
    }

    @Then("^after create player status should be (\\d+)$")
    public void after_create_player_status_should_be(int httpStatus) throws Throwable {
        assertThat(httpStatus, is(responseEntity.getStatusCode().value()));
    }
}
