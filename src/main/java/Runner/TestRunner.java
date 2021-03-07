package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "C:\\Users\\Ashwini\\IdeaProjects\\MySeleniumPractice\\src\\test\\java\\Features",
                plugin = { "json:target/cucumber.json", "pretty",
                        "html:target/cucumber-reports" } ,
                glue = "StepDefinations")

public class TestRunner

{


}
