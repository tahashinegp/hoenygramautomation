package com.honeygramtest.steps;

import com.honeygram.screens.LogInScreen;
import com.honeygramtest.utilites.Helper;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;

public class HoneygramloginStepdef {
    LogInScreen logInScreen;
    AndroidDriver driver;
    @When("^User will open the Honeygram app$")
    public void userWillOpenTheHoneygramApp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logInScreen = Helper.getPage(LogInScreen.class);

        throw new PendingException();
    }

    @Given("^User will enter login id <login_id>$")
    public void userWillEnterLoginIdLogin_id() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logInScreen.enterUsername();
        throw new PendingException();
    }

    @Then("^User will enter password <password>$")
    public void userWillEnterPasswordPassword() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User will click enter button$")
    public void userWillClickEnterButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
