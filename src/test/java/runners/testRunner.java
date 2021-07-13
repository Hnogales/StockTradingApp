package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class testRunner {
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features="./src/test/resources/features", 
			glue="step_definitions",
			dryRun=false,
			tags="@"
			)
	public class TestRunner {
		
		//dryRun = we are telling cucumber to run only the scenario steps, not the implementation

	}
}
