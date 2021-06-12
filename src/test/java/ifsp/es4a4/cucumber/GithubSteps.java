package ifsp.es4a4.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class GithubSteps {
    private WebDriver driver;

    @Given("Eu estou no site {string}")
    public void eu_estou_no_site(String site) {
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--headless");

        setDriverPath();
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(site);
    }

    @When("Eu procuro por {string}")
    public void eu_procuro_por(String searchtext) {
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(searchtext + "\n");
        driver.findElement(By.name("q")).submit();
    }

    @When("Eu clico no link com descricao {string}")
    public void eu_clico_no_link_com_descricao(String expectedLinkText) {
        driver.findElement(By.linkText(expectedLinkText));
    }

    @And("Eu clico no link com descricao {string} e {string}")
    public void euClicoNoLinkComDescricaoE(String klass, String linkToUser) {
        List<WebElement> menuItems = driver.findElements(By.className(klass));
        Optional<WebElement> users = menuItems.stream()
                .filter(item -> item.getAttribute("href").contains(linkToUser)).findFirst();
        users.ifPresent(WebElement::click);
    }

    @Then("Eu deveria encontrar um link com descricao {string}")
    public void eu_deveria_encontrar_um_link_com_descricao(String expectedLinkText) {
        assertNotNull(driver.findElement(By.linkText(expectedLinkText)));
        driver.quit();
    }

    private void setDriverPath() {
        String path = System.getProperty("user.dir") + "/src/main/";
        if (System.getProperty("os.name").contains("win"))
            path += "resources/geckodriver-v0.29.1-win64/geckodriver.exe";
        else
            path += "resources/geckodriver-v0.29.1-linux64/geckodriver";
        System.setProperty("webdriver.gecko.driver", path);
    }
}
