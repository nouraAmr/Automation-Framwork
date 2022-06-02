package runner;

import Tests.TestBase;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@io.cucumber.testng.CucumberOptions(features="src/test/java/features",glue= {"steps"},plugin= {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase  {
	

}
