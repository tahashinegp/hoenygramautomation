package com.honeygram.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        monochrome = true,
        tags = "@Candidate",
        features = "src/test/resources/features/",
        glue = "test.com.honeygram.steps" ,
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
        }
)
public class FeatureRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(groups = "cucumber features", description="cucumber scenarios", dataProvider = "scenarios")
    public void feature(CucumberFeatureWrapper featureWrapper){
        System.out.println("Cucumber Test Class Inside Test");
        System.out.println(featureWrapper.getCucumberFeature());
        testNGCucumberRunner.runCucumber(featureWrapper.getCucumberFeature());

    }

    @DataProvider
    public Object[][] getScenariodata() {
        System.out.println("Data Provider test Class");
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

}
