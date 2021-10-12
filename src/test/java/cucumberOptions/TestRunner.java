package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefnition", strict=true, monochrome=true,
		plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml"})

public class TestRunner {

}
