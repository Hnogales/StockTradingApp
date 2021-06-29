package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:Reports/cucumber-pretty","json:Reports/cucumber.json"},
		features="./src/test/resources/features",
		glue="step_definitions",
		dryRun=false
		)




public class testRunner {
		
		//dryRun = we are telling cucumber to run only the scenario steps, not the implementation

	
}
