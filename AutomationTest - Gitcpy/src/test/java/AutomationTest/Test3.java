package AutomationTest;

import com.thoughtworks.selenium.webdriven.commands.GetBodyText;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Test3 {

    WebDriver driver = null;

    @Given("^I want to connect to \"([^\"]*)\"$")
    public void iWantToConnectTo(String webs) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver = new FirefoxDriver();
        driver.navigate().to(webs);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @When("^I click on Parcel Enquiry$")
    public void i_click_on_Parcel_Enquiry() throws Throwable {
        driver.findElement(By.partialLinkText("Parcel Enquiry")).click();

    }

    @When("^I click on option postcode$")
    public void i_click_on_option_postcode() throws Throwable {
        driver.findElement(By.id("P64_RADIO_TYPE_1")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @When("^I enter my postcode \"([^\"]*)\"$")
    public void i_enter_my_postcode(String pst) throws Throwable {
        driver.findElement(By.id("P64_POST_CODE")).sendKeys(pst);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @When("^I select parcel search$")
    public void i_select_parcel_search() throws Throwable {
        driver.findElement(By.id("SEARCH")).click();
    }

    @Then("^I see a list of parcels$")
    public void i_see_a_list_of_parcels() throws Throwable {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        assertTrue("Un-Verified!", driver.getPageSource().contains("Parcel Enquiry Selection"));

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\paul.buck\\Downloads\\Screenshot\\List_of_Parcels.png"), true);

        driver.quit();



    }

}
