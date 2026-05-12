package com.example.ExperteamPage.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(xpath = "//img[@class='logo-main scale-with-grid']")
	private WebElement  logo;

	@FindBy(xpath = "//li[@class='slogan']")
	private WebElement  slogan;


	@FindBy(xpath = "//a[normalize-space()='+216 29 674 204']")
	private WebElement  iconphone;
	@FindBy(xpath = "//a[normalize-space()='contact@expertunisie.com']")
	private WebElement  iconmail;


	@FindBy(xpath = "//span[normalize-space()='180']")
	private WebElement  number1;
	
	@FindBy(xpath = "//span[normalize-space()='8']")
	private WebElement  number2;
	
	@FindBy(xpath = "//img[@alt='Test de Logiciels']")
	private WebElement  testlogiciel;
	
	@FindBy(xpath = "//img[@alt='Gestion de projets']")
	private WebElement  gestionprojet;
	
	@FindBy(xpath = "//img[@alt='Business Analyst']")
	private WebElement  businessanalyste;
	
	@FindBy(xpath = "//img[@alt='Business Analyst']")
	private WebElement  developpementapplication;
	
	@FindBy(xpath = "//img[@alt='4']")
	private WebElement  serviceinformatique;
	
	@FindBy(xpath = "//img[@alt='Data et Intelligence Artificielle']")
	private WebElement  DataIntelligenceArt;
	
	@FindBy(xpath = "//mark[@class='has-inline-color has-vivid-green-cyan-color']")
	private WebElement  formation;
	
	
	@FindBy(xpath = "//a[normalize-space()='#ISTQB']")
	private WebElement  istqb;
	
	
	@FindBy(xpath = "//p[@class='tags']/a")
	private List<WebElement> tags;
	
	
	
	
	public WebElement getIstqb() {
		return istqb;
	}


	public void setIstqb(WebElement istqb) {
		this.istqb = istqb;
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


	public WebElement getIconphone() {
		return iconphone;
	}


	public void setIconphone(WebElement iconphone) {
		this.iconphone = iconphone;
	}


	public WebElement getIconmail() {
		return iconmail;
	}


	public void setIconmail(WebElement iconmail) {
		this.iconmail = iconmail;
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


	public WebElement getTestlogiciel() {
		return testlogiciel;
	}


	public void setTestlogiciel(WebElement testlogiciel) {
		this.testlogiciel = testlogiciel;
	}


	public WebElement getGestionprojet() {
		return gestionprojet;
	}


	public void setGestionprojet(WebElement gestionprojet) {
		this.gestionprojet = gestionprojet;
	}


	public WebElement getBusinessanalyste() {
		return businessanalyste;
	}


	public void setBusinessanalyste(WebElement businessanalyste) {
		this.businessanalyste = businessanalyste;
	}


	public WebElement getDeveloppementapplication() {
		return developpementapplication;
	}


	public void setDeveloppementapplication(WebElement developpementapplication) {
		this.developpementapplication = developpementapplication;
	}


	public WebElement getServiceinformatique() {
		return serviceinformatique;
	}


	public void setServiceinformatique(WebElement serviceinformatique) {
		this.serviceinformatique = serviceinformatique;
	}


	public WebElement getDataIntelligenceArt() {
		return DataIntelligenceArt;
	}


	public void setDataIntelligenceArt(WebElement dataIntelligenceArt) {
		DataIntelligenceArt = dataIntelligenceArt;
	}


	public WebElement getFormation() {
		return formation;
	}


	public void setFormation(WebElement formation) {
		this.formation = formation;
	}


	public List<WebElement> getTags() {
		return tags;
	}


	public void setTags(List<WebElement> tags) {
		this.tags = tags;
	}






}
