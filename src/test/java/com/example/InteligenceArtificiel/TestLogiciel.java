package com.example.InteligenceArtificiel;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class TestLogiciel {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private  Actions action;
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
 	  WebDriverManager.chromedriver().setup();
 	 
 	  ChromeOptions options = new ChromeOptions();
 		options.addArguments("start-maximized");
 		options.addArguments("--remote-allow-origins=*");
 		driver = new ChromeDriver(options);
 		 action = new Actions(driver); 
    baseUrl = "https://www.expertunisie.com/nos-formations/test-logiciels/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    js = (JavascriptExecutor) driver;
  }
  @Test
  private void istqbgenerativeIAPage() {
		{
			
			
		    action.moveToElement(driver.findElement(By.xpath("//span[@data-hover=\"ISTQB générative IA\"]"))).click().perform();
		    
		    assertEquals("ISTQB Generative IA Testing", driver.findElement(By.xpath("//h1[@class='title']")).getText());
		 
		  
		   List<WebElement> elements=  driver.findElements(By.xpath("//div[contains(@class,'question')]"));
		 
		  //p[contains(text(),'issue de cette formation, les participants seront ')]
		  
		       elements.get(0).click();
		  
		      assertTrue(driver.findElement(By.xpath("//div[@class='question active']//p")).getText().contains("IA générative appliquée au test logiciel."));
		 
		     System.out.println(elements.get(0).getText());
		    
		    
		      assertEquals(" Objectifs",elements.get(0).findElement(By.cssSelector("div h2")).getText());
			 
		      elements.get(1).click();
		  
		  
		      assertTrue(driver.findElement(By.xpath("//div[@id='Content']/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/p")).getText().contains("➤ Connaissances de base en test logiciel."));
		     assertEquals(" Prérequis",elements.get(1).findElement(By.cssSelector("div h2")).getText());
				
		      elements.get(2).click();  
		   
		      assertEquals("Certification",elements.get(2).findElement(By.cssSelector("div h2")).getText());
		      elements.get(2).click();  
		      elements.get(3).click();
		    
		      assertEquals(" Programme",elements.get(3).findElement(By.cssSelector("div h2")).getText());
		      elements.get(3).click();
				
		      elements.get(4).click();   
		      assertEquals("FAQ",elements.get(4).findElement(By.cssSelector("div h2")).getText());
				
		  
	}	
	}





  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
