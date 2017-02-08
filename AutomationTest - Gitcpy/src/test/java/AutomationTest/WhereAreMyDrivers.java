package AutomationTest;

import cucumber.api.PendingException;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhereAreMyDrivers {

    WebDriver driver = null;

    @Given("^I would like to go to \"([^\"]*)\"$")
    public void i_would_like_to_go_to(String wete) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\paul.buck\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(wete);
    }

    @When ("^I select Where are my drivers$")
    public void i_select_Where_are_my_drivers() throws Throwable {
        driver.findElement(By.partialLinkText("Where Are My Drivers ?")).click();

    }
    @And("^I select drivers$")
    public void i_select_drivers() throws Throwable {
        new Select(driver.findElement(By.className("selectlist"))).selectByVisibleText("Warrington");
        Thread.sleep(4000);
        //driver.findElement(By.xpath("//div[@id='mapPlaceholder']/div/div/div[3]")).click();






    }

    @Then("^I should see drivers$")
    public void i_should_see_drivers() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 1000);

        Thread.sleep(4000);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\paul.buck\\Downloads\\Screenshot\\Drivers.png"), true);


    }


}


