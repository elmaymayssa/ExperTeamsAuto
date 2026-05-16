package com.experttunisie.stepdefinitions;

import java.util.Set;

import org.testng.Assert;

import com.example.ExperteamPage.com.Base.BasePage;
import com.example.ExperteamPage.com.pages.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps extends BasePage {

    HomePage homePage;

    @Before
    public void setUp() {
        setupBrowser();
    }
    
    @When("user clics social media")
    public void user_clics_social_media() {
    	homePage.getFacebook().click();
    	//Log
    	homePage.getYoutube().click();
    	//Log
    }

    @Then("social media pages are displayed correctly")
    public void social_media_pages_are_displayed_correctly() {
    	Set<String> urls = homePage.getCurrentUrlFromWindowHanldes();
    	
    	System.out.println(urls.toString());
    	
    	Assert.assertTrue(homePage.isCorrectCurrentUrl(urls, "https://www.youtube.com/channel/UCAtz2FDsyadRE9FpfwAJVmA"));
    	
    	Assert.assertTrue(homePage.isCorrectCurrentUrl(urls, "https://www.expertunisie.com/"));
        
    	Assert.assertTrue(homePage.isCorrectCurrentUrl(urls, "https://www.facebook.com/Expert.Team.Tunisie/"));
        
    
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