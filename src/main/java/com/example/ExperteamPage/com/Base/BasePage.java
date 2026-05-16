package com.example.ExperteamPage.com.Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	

public static WebDriver driver;
    
    public void setupBrowser() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }
    
    
    public void openWebsite() {

        driver.get("https://www.expertunisie.com/");
        
    }

    
    public void closeBrowser() {

        driver.quit();
    }
}
