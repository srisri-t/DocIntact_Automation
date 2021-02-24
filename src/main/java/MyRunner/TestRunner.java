package MyRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;
//import com.doc.qa.util.Rep_Mail;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
        		features = "src/main/java/Features/1_Landing_page.feature",
        		glue = {"stepDefinitions"},
                tags = {"~@Ignore"},
                format = {
                        "pretty",
                        "html:target/cucumber-reports/cucumber-pretty",
                        "json:target/cucumber-reports/CucumberTestReport.json",
                        "rerun:target/cucumber-reports/rerun.txt"
                },plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html","json:target/json-cucumber-reports/cukejson.json","testng:target/testng-cucumber-reports/cuketestng.xml","json:target/cucumber-reports/CucumberTestReport.json"})

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
    	Reporter.loadXMLConfig("Extent-config.xml");
        testNGCucumberRunner.finish();
//        Rep_Mail.Email_Report();
    }
}