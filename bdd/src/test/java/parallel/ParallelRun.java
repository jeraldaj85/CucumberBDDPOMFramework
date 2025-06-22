package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/parallel" }, 
glue = { "parallel" }, 
monochrome=true,
publish=true,
plugin = {
		"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/"

})
public class ParallelRun extends AbstractTestNGCucumberTests{
	
	
    
	@DataProvider(parallel=true)
	@Override
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	

}
