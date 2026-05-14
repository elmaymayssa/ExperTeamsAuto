package com.example.ExperteamPage.com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ================= FOOTER ROOT =================
    @FindBy(tagName = "footer")
    private WebElement footer;

    // ================= SECTIONS =================
    @FindBy(xpath = "//*[@id=\"Footer\"]/div[1]")
    private List<WebElement> sections;

    // ================= SPECIFIC SECTIONS =================
    @FindBy(id = "widget_mfn_menu-27")
    private WebElement planDuSite;

    @FindBy(id = "widget_mfn_menu-13")
    private WebElement metiersAvenir;

    @FindBy(xpath = "widget_mfn_menu-5")
    private WebElement gestionProjets;

    @FindBy(xpath = "widget_mfn_menu-24")
    private WebElement testsLogiciels;

    @FindBy(xpath = "widget_mfn_menu-28")
    private WebElement developpement;

    // ================= METHODS =================

    public boolean isFooterDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(footer));
        return footer.isDisplayed();
    }

    public boolean hasSections() {
        return sections != null && sections.size() > 0;
    }


    public boolean sectionExists(String name) {
        return sections.stream()
                .anyMatch(el -> el.getText().trim().contains(name));
    }
}