package com.example.InteligenceArtificiel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogiciel {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;

    private Actions action;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        action = new Actions(driver);

        baseUrl =
                "https://www.expertunisie.com/nos-formations/test-logiciels/";

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        js = (JavascriptExecutor) driver;
    }

    @Test
    public void istqbgenerativeIAPage() {

        driver.get(baseUrl);

        action.moveToElement(
                driver.findElement(
                        By.xpath("//span[@data-hover='ISTQB générative IA']")
                )
        ).click().perform();

        Assert.assertEquals(
                driver.findElement(By.xpath("//h1[@class='title']")).getText(),
                "ISTQB Generative IA Testing"
        );

        List<WebElement> elements = driver.findElements(
                By.xpath("//div[contains(@class,'question')]")
        );

        // Objectifs
        elements.get(0).click();

        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//div[@class='question active']//p")
                ).getText().contains(
                        "IA générative appliquée au test logiciel."
                )
        );

        System.out.println(elements.get(0).getText());

        Assert.assertEquals(
                elements.get(0)
                        .findElement(By.cssSelector("div h2"))
                        .getText(),
                " Objectifs"
        );

        // Prérequis
        elements.get(1).click();

        Assert.assertTrue(
                driver.findElement(
                        By.xpath(
                                "//div[@id='Content']/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/p"
                        )
                ).getText().contains(
                        "➤ Connaissances de base en test logiciel."
                )
        );

        Assert.assertEquals(
                elements.get(1)
                        .findElement(By.cssSelector("div h2"))
                        .getText(),
                " Prérequis"
        );

        // Certification
        elements.get(2).click();

        Assert.assertEquals(
                elements.get(2)
                        .findElement(By.cssSelector("div h2"))
                        .getText(),
                "Certification"
        );

        // Programme
        elements.get(3).click();

        Assert.assertEquals(
                elements.get(3)
                        .findElement(By.cssSelector("div h2"))
                        .getText(),
                " Programme"
        );

        // FAQ
        elements.get(4).click();

        Assert.assertEquals(
                elements.get(4)
                        .findElement(By.cssSelector("div h2"))
                        .getText(),
                "FAQ"
        );

        System.out.println("Test OK");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
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