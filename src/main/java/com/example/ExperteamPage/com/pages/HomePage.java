package com.example.ExperteamPage.com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ===================== LOCATORS =====================

    @FindBy(xpath = "//img[@class='logo-main scale-with-grid']")
    private WebElement logo;

    @FindBy(xpath = "//li[@class='slogan']")
    private WebElement slogan;

    @FindBy(xpath = "//a[normalize-space()='+216 29 674 204']")
    private WebElement iconPhone;

    @FindBy(xpath = "//a[normalize-space()='contact@expertunisie.com']")
    private WebElement iconMail;

    @FindBy(xpath = "//span[normalize-space()='180']")
    private WebElement number1;

    @FindBy(xpath = "//span[normalize-space()='8']")
    private WebElement number2;

    @FindBy(xpath = "//img[@alt='Test de Logiciels']")
    private WebElement testLogiciel;

    @FindBy(xpath = "//img[@alt='Gestion de projets']")
    private WebElement gestionProjet;

    @FindBy(xpath = "//img[@alt='Business Analyst']")
    private WebElement businessAnalyst;

    @FindBy(xpath = "//img[@alt='Data et Intelligence Artificielle']")
    private WebElement dataIA;

    @FindBy(xpath = "//mark[@class='has-inline-color has-vivid-green-cyan-color']")
    private WebElement formation;

    @FindBy(xpath = "//a[normalize-space()='#ISTQB']")
    private WebElement istqb;

    @FindBy(xpath = "//p[@class='tags']/a")
    private List<WebElement> tags;

    // ===================== ACTIONS =====================

    public void openWebsite() {
        driver.get("https://www.expertunisie.com/");
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public boolean isSloganDisplayed() {
        return slogan.isDisplayed();
    }

    public boolean isPhoneDisplayed() {
        return iconPhone.isDisplayed();
    }

    public boolean isMailDisplayed() {
        return iconMail.isDisplayed();
    }

    public boolean isFormationDisplayed() {
        return formation.isDisplayed();
    }

    public boolean isISTQBDisplayed() {
        return istqb.isDisplayed();
    }

    public WebElement getLogo() {
		return logo;
	}

	public void setLogo(WebElement logo) {
		this.logo = logo;
	}

	public WebElement getSlogan() {
		return slogan;
	}

	public void setSlogan(WebElement slogan) {
		this.slogan = slogan;
	}

	public WebElement getIconPhone() {
		return iconPhone;
	}

	public void setIconPhone(WebElement iconPhone) {
		this.iconPhone = iconPhone;
	}

	public WebElement getIconMail() {
		return iconMail;
	}

	public void setIconMail(WebElement iconMail) {
		this.iconMail = iconMail;
	}

	public WebElement getNumber1() {
		return number1;
	}

	public void setNumber1(WebElement number1) {
		this.number1 = number1;
	}

	public WebElement getNumber2() {
		return number2;
	}

	public void setNumber2(WebElement number2) {
		this.number2 = number2;
	}

	public WebElement getTestLogiciel() {
		return testLogiciel;
	}

	public void setTestLogiciel(WebElement testLogiciel) {
		this.testLogiciel = testLogiciel;
	}

	public WebElement getGestionProjet() {
		return gestionProjet;
	}

	public void setGestionProjet(WebElement gestionProjet) {
		this.gestionProjet = gestionProjet;
	}

	public WebElement getBusinessAnalyst() {
		return businessAnalyst;
	}

	public void setBusinessAnalyst(WebElement businessAnalyst) {
		this.businessAnalyst = businessAnalyst;
	}

	public WebElement getDataIA() {
		return dataIA;
	}

	public void setDataIA(WebElement dataIA) {
		this.dataIA = dataIA;
	}

	public WebElement getFormation() {
		return formation;
	}

	public void setFormation(WebElement formation) {
		this.formation = formation;
	}

	public WebElement getIstqb() {
		return istqb;
	}

	public void setIstqb(WebElement istqb) {
		this.istqb = istqb;
	}

	public List<WebElement> getTags() {
		return tags;
	}

	public void setTags(List<WebElement> tags) {
		this.tags = tags;
	}

	public int getTagsCount() {
        return tags.size();
    }
}