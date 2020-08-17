package integration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StepDefinitionsTests extends SpringIntegrationTest {

    @Given("^the client calls /hello$")
    public void clientIssuesGetHello() {
        executeGet("http://localhost:8080/api/hello");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();

        assertThat("status code is incorrect : " + latestResponse.getBody(),
                    currentStatusCode.value(), is(statusCode));

    }


}
