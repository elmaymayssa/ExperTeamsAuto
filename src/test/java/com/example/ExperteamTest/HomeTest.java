package com.example.ExperteamTest;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.example.ExperteamPage.com.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HomeTest {
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private  Actions action;
	  JavascriptExecutor js;
	  HomePage homepage;

	  
	@Before
	public void setUp() throws Exception {
		

        WebDriverManager.chromedriver().setup();
	   
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		
		homepage = new HomePage(driver);
		
		
	    baseUrl = "https://www.expertunisie.com/";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    js = (JavascriptExecutor) driver;

		
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		
		driver.get(baseUrl);
		
		assertNotNull(homepage.getLogo());
		System.out.print("logo existe");
		assertEquals( "Notre conseiller client répond à vos questions", homepage.getSlogan().getText());
		System.out.println("Slogan verifie ");
		System.out.println(homepage.getIconphone().getText());
		assertEquals("+216 29 674 204", homepage.getIconphone().getText());
		System.out.println("phone verifie ");
		assertEquals("contact@expertunisie.com", homepage.getIconmail().getText());
		System.out.println ("email verifie ");
		Thread.sleep(30);
		assertEquals("180", homepage.getNumber1().getText());
		assertEquals("8", homepage.getNumber2().getText());
		System.out.println("phone2 verifie ");

		assertNotNull(homepage.getTestlogiciel());
		System.out.println("getTestlogiciel verifie ");

	//	assertNotNull(homepage.getDeveloppementapplication());
		assertNotNull(homepage.getGestionprojet());
		System.out.println("getGestionprojet verifie ");

		assertNotNull(homepage.getServiceinformatique());
		System.out.println("getServiceinformatique verifie ");

		assertNotNull(homepage.getDataIntelligenceArt());
		assertNotNull(homepage.getBusinessanalyste());
		
		assertEquals("Formations & Certifications", homepage.getFormation().getText());
		
		assertEquals("#ISTQB", homepage.getIstqb().getText());
		
		 System.out.println("getServiceinformatique verifie ");
		 assertTrue(homepage.getTags().size() > 0);	
		    System.out.println("size      "+ homepage.getTags().size());

		    int i = 0;
		    boolean found = false;

		    for (WebElement tag : homepage.getTags()) {

		        System.out.println(tag.getText());

		        if (tag.getText().equals("#Selenium")) {

		            i++;
		            found = true;

		        }
		    }

		    System.out.println("Nombre de #Selenium : " + i);

		    assertTrue(found);

			
	System.out.println("is ok ");
	}	

		 
			
	
		
	
	}


