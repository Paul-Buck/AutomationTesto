package AutomationTest;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

     WebDriver driver = null;

    @Given("^I want \"([^\"]*)\"$")
    public void i_want(String ssite) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\paul.buck\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(ssite);

    }

    @Then("^Im \"([^\"]*)\" the site$")
    public void im_the_site(String sch) throws Throwable {

        driver.findElement(By.id("lst-ib")).sendKeys(sch + Keys.ENTER);
        driver.findElement(By.name("btnG")).click();
    }

    @And("^Im select the BBC$")
    public void im_select_the_BBC() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Home - BBC News")).click();
    }

    @And("^Im again \"([^\"]*)\" the site$")
    public void im_again_the_site(String sch2) throws Throwable {

        driver.findElement(By.id("orb-search-q")).sendKeys(sch2);
        driver.findElement(By.className("se-searchbox__submit")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Im select the first result, and get taken to the Pink Floyd page$")
    public void im_select_the_first_result() throws Throwable {

        driver.findElement(By.className("rs_touc")).click();


    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.

            driver.quit();
        }
    }



    // File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // FileUtils.copyFile(scrFile, new File("C:\\Users\\paul.buck\\Downloads\\Screenshot\\PinkChrome.png"), true);


    }

