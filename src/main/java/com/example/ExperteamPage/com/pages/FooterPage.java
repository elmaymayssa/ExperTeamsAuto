package com.example.ExperteamPage.com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FooterPage extends PageObject{

   
    public FooterPage(WebDriver driver) {
       super(driver);
        
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
    
    @FindBy(xpath = "//a[starts-with(@href,'https://www.expertunisie.com/')]")
    private List<WebElement> links;

    

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

	public boolean hasLinks() {
		
		return (links.size()==100)? true:false;
	}
}