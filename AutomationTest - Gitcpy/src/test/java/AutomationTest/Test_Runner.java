package AutomationTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\paul.buck\\Downloads\\AutomationTest\\src\\test\\java\\Feature",
        glue = "classpath:AutomationTest",
        plugin = "html:target/selenium-reports",
        tags = {"@pear, @pinkFloyd, @strawBerry, @banana, @Cheese, @orange"},
        format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}

)
public class Test_Runner {
}


