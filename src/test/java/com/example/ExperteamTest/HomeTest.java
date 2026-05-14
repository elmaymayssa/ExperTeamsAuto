package com.example.ExperteamTest;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.ExperteamPage.com.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest {

    private WebDriver driver;
    private String baseUrl;
    private Actions action;
    JavascriptExecutor js;
    HomePage homepage;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        homepage = new HomePage(driver);

        baseUrl = "https://www.expertunisie.com/";

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {

        driver.get(baseUrl);

        Assert.assertNotNull(homepage.getLogo());
        System.out.println("Logo existe");

        Assert.assertEquals(
                homepage.getSlogan().getText(),
                "Notre conseiller client répond à vos questions"
        );

        System.out.println("Slogan vérifié");

        System.out.println(homepage.getIconMail().getText());

        Assert.assertEquals(
                homepage.getIconMail().getText(),
                "+216 29 674 204"
        );

        System.out.println("Phone vérifié");

        Assert.assertEquals(
                homepage.getIconMail().getText(),
                "contact@expertunisie.com"
        );

        System.out.println("Email vérifié");

        Thread.sleep(1000);

        Assert.assertEquals(
                homepage.getNumber1().getText(),
                "180"
        );

        Assert.assertEquals(
                homepage.getNumber2().getText(),
                "8"
        );

        System.out.println("Numbers vérifiés");

        Assert.assertNotNull(homepage.getTestLogiciel());

        System.out.println("Test logiciel vérifié");

        Assert.assertNotNull(homepage.getGestionProjet());

        System.out.println("Gestion projet vérifié");

       
        System.out.println("Service informatique vérifié");


        Assert.assertEquals(
                homepage.getFormation().getText(),
                "Formations & Certifications"
        );

        Assert.assertEquals(
                homepage.getIstqb().getText(),
                "#ISTQB"
        );

        System.out.println("Formation vérifiée");

        Assert.assertTrue(
                homepage.getTags().size() > 0
        );

        System.out.println("Nombre de tags : "
                + homepage.getTags().size());

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

        Assert.assertTrue(found);

        System.out.println("Test OK");
    }
}