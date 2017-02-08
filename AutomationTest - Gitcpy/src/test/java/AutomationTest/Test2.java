package AutomationTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Test2 {

    WebDriver driver = null;

    @Given("^I go to Yodel \"([^\"]*)\"$")
    public void i_go_to_Yodel(String web) throws Throwable {
        driver = new FirefoxDriver();
        driver.navigate().to(web);
    }

    @Then("^I Enter In a \"([^\"]*)\"$")
    public void i_Enter_In_a(String Postcode) throws Throwable {
        driver.findElement(By.id("PostCode")).sendKeys(Postcode);

    }

    @And("^I select Search$")
    public void i_select_Search() throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("PostCode")).sendKeys(Keys.ENTER);

    }

    @Then("^I should be given a validation prompt message$")
    public void i_should_be_given_a_validation_prompt_message() throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.className("error-msg")).isDisplayed();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\paul.buck\\Downloads\\Screenshot\\screenshot2.png"), true);

        driver.quit();
    }

}
