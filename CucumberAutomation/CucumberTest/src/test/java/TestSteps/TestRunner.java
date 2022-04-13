package TestSteps;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/resources/Features",glue={"TestSteps"},
@CucumberOptions(features="C:/Users/atikah amin/git/CucumberAutomation/CucumberTest/src/test/resources/Features",glue={"TestSteps"},

monochrome = true,
plugin = {"pretty","junit:target/JunitReport/report.xml",
		"json:target/JSONReports/report.json",
		"html:target/HtmlReports/HtmlReports.html"}
		)
public class TestRunner {

}
