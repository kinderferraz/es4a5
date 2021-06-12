package ifsp.es4a4.cucumber;

import ifsp.es4a4.exercicios.bdd.Hello;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HiSteps {

    private Hello hello;
    private String hi;

    @Given("^Minha saudação e \"([^\"]*)\"$")
    public void saudacao(String greeting){
        hello = new Hello(greeting);
    }

    @When("eu executo minha aplicação")
    public void eu_executo_minha_aplicacao() {
        hi = hello.sayHi();
    }

    @Then("ela deveria responder com {string}")
    public void ela_deveria_responder_com(String string) {
        assertEquals(string, hi);
    }

}
