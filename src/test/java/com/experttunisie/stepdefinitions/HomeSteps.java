package com.experttunisie.stepdefinitions;

import org.testng.Assert;

import com.example.ExperteamPage.com.Base.BasePage;
import com.example.ExperteamPage.com.pages.HomePage;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class HomeSteps extends BasePage {

    HomePage homePage;

    @Before
    public void setUp() {
        setupBrowser();
    }

    @Given("user opens chrome browser")
    public void user_opens_chrome_browser() {
        homePage = new HomePage(driver);
    }

    @When("user enters Expert Tunisie URL")
    public void user_enters_expert_tunisie_url() {
        homePage.openWebsite();
    }

    @Then("Expert Tunisie home page should be displayed")
    public void expert_tunisie_home_page_should_be_displayed() {
        Assert.assertTrue(homePage.isLogoDisplayed());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}