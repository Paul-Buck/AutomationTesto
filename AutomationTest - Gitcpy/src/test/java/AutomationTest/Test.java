package AutomationTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class Test {
    WebDriver driver = null;

    @Given("^I go to \"([^\"]*)\"$")
    public void iWantToConnectTo(String website) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver = new FirefoxDriver();
        driver.navigate().to(website);

    }

    @Then("^I \"([^\"]*)\" the site$")
    public void i_the_site(String search) throws Throwable {

        driver.findElement(By.id("lst-ib")).sendKeys(search);
        driver.findElement(By.name("btnG")).click();
    }

    @And("^I select the BBC$")
    public void i_select_the_BBC() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Home - BBC News")).click();
    }

    @And("^I again \"([^\"]*)\" the site$")
    public void i_again_the_site(String search2) throws Throwable {

        driver.findElement(By.id("orb-search-q")).sendKeys(search2);
        driver.findElement(By.className("se-searchbox__submit")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^I select the first result, and get taken to the Pink Floyd page$")
    public void i_select_the_first_result() throws Throwable {

        driver.findElement(By.linkText("Pink Floyd")).click();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\paul.buck\\Downloads\\Screenshot\\Pink.png"), true);

        driver.quit();

    }

}

