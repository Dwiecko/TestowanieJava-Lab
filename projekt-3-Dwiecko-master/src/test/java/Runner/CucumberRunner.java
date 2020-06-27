package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"PageSteps"},
        plugin = {
                "pretty", "html:target/cucumberHtmlReport",
                "html:target/cucumberHtmlReport",
                "pretty:target/cucumber-json-report.json"
        })
public class CucumberRunner {}