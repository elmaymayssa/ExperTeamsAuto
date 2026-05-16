package com.experttunisie.stepdefinitions;

import org.testng.Assert;

import com.example.ExperteamPage.com.Base.BasePage;
import com.example.ExperteamPage.com.pages.FooterPage;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;

public class FooterSteps extends BasePage {

    private FooterPage footerPage;

    // ✅ IMPORTANT: initialization to avoid NullPointerException
    public FooterSteps() {
        footerPage = new FooterPage(driver);
    }

    @When("user opens Expert Tunisie website")
    public void user_opens_expert_tunisie_website() {
        openWebsite();
        footerPage.log.info("Ouverture de la page Web : OK");
    }

    @Then("footer should be displayed")
    public void footer_should_be_displayed() {
        Assert.assertTrue(footerPage.isFooterDisplayed());
        footerPage.log.info("Footer Page is Displayed");
    }
    

    @Then("footer should contain all sections")
    public void footer_should_contain_all_sections() {

        Assert.assertTrue(footerPage.hasSections());
        footerPage.log.info("Footer has Selection");

        Assert.assertTrue(footerPage.sectionExists("Plan du site"));
        footerPage.log.info("Footer Plab du site ");
        Assert.assertTrue(footerPage.sectionExists("Métiers"));
        footerPage.log.info("Section Métier Existe");
        Assert.assertTrue(footerPage.sectionExists("Gestion des projets"));
        footerPage.log.info("Section Gestion de projet is Displayed");
        Assert.assertTrue(footerPage.sectionExists("Tests Logiciels"));
        footerPage.log.info("Test Logiciels is Displayed");
    }

    @Then("footer links should be displayed")
    public void footer_links_should_be_displayed() {
       Assert.assertTrue(footerPage.hasLinks());
       footerPage.log.info("Footer Has Links : OK");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}