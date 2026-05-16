package com.example.ExperteamPage.com.pages;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	protected WebDriver driver;
	   public Logger log;
	   public WebDriverWait wait;
	//   private String folder="D:\\Temp\\";
	   public Actions action;
	    public PageObject(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        log = Logger.getLogger(Log.class.getName());
		    log.setLevel(Level.INFO);
	        action =new Actions(driver);
	        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	    }
	    public  int compterOccurrence(String chaine, char caractere) {
	        int compteur = 0;
	        for (int i = 0; i < chaine.length(); i++) {
	            if (chaine.charAt(i) == caractere) {
	                compteur++;
	            }
	        }
	        return compteur;
	    }
		
		public void back()
		{
			driver.navigate().back();
		}
		
		public void forward()
		{
			driver.navigate().forward();
		}
		 public void inputText(WebElement element, String texte)
		    {
		    	element.clear();
		    	
		    	element.sendKeys(texte);
		    }
		 
		 public void perform(WebElement element)
		 {
			 //Focus
			 try {
				action.moveToElement(element).click().perform();
				
				
			} catch (Exception e) {
				
			  System.out.println("Problème de clic bouton " + element.getText());
			}
		 }
		 
		 public  String closeAlertAndGetItsText() {
			    try {
			      Alert alert = driver.switchTo().alert();
			      String alertText = alert.getText();
			      
			      alert.accept();
			     
			      return alertText;
			      
			    } catch (Exception e){
			    	
			    	return "";
			    }
			  }
		 
		
		 
		 public void takeScreenShot(String fileName)
		 {
			    TakesScreenshot screenshot = (TakesScreenshot) driver;
	            
			    File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
	            
	            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	       	    fileName = fileName+ "_" + timeStamp + ".jpg";

	            // Définir l'emplacement de sauvegarde
	            File destinationFile = new File(fileName);
	            
	            System.out.println("Capture d'écran enregistrée : " + destinationFile.getAbsolutePath());

	            // Copier le fichier source vers la destination
	            try {
					FileUtils.copyFile(sourceFile, destinationFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 
		 public void takeScreenShot(String fileName, WebElement element)
		 {
			   TakesScreenshot screenshot = (TakesScreenshot) element;
	            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
	            
	            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	       	    fileName = fileName+ "_" + timeStamp + ".jpg";

	            // Définir l'emplacement de sauvegarde
	            File destinationFile = new File(fileName);
	            
	            System.out.println("Capture d'écran enregistrée : " + destinationFile.getAbsolutePath());

	            // Copier le fichier source vers la destination
	            try {
					FileUtils.copyFile(sourceFile, destinationFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 
		 public void takeScreenShot(String folderPath, String fileName)
		 {
			 
			      File directory = new File(folderPath);
			      
			       //folderPath = System.getProperty("user.home") + "/imprimeEcran";

		        // Vérifier si le dossier existe, sinon le créer
			      if (!directory.exists()) {
			            if (directory.mkdirs()) {
			                System.out.println("Dossier créé avec succès : " + folderPath);
			            } else {
			                System.out.println("Erreur : Impossible de créer le dossier !");
			                return;  // Arrêter l'exécution si le dossier ne peut pas être créé
			            }
			        }
		        
			   TakesScreenshot screenshot = (TakesScreenshot) driver;
	            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

	            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            File destinationFile = new File(folderPath + "/screenshot_" + timeStamp + ".png");

	            
	            System.out.println("Capture d'écran enregistrée : " + destinationFile.getAbsolutePath());

	            // Copier le fichier source vers la destination
	            try {
					FileUtils.copyFile(sourceFile, destinationFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 
		 public Alert getAlert()
		 {
			 Alert alert = driver.switchTo().alert();
			 
			 
			 return alert;
		 }
		 
		 public void dismiss() {
				
			 driver.switchTo().alert().dismiss();
		}
		 
		 public void accept() {
				
			 driver.switchTo().alert().accept();
		}
			
		 
		 public void dragAndDrop(WebElement element, int x, int y)
		 {
			 action.dragAndDropBy(element, x, y).perform();
			
		 }
		 
		 public void dragAndDrop(WebElement source, WebElement desination)
		 {
			 action.dragAndDrop(source, desination).perform();
		 }
		 
		 public void doubleClick(WebElement element)
		 {
			 action.doubleClick(element).perform();
		 }
		 
		//div[@class='mk-map-node-element']
		 
		 public void switchToFrame(int index)
		 {
			 driver.switchTo().frame(index);
			 
		 }
		 
		 public void switchToFrame(String nameOrId)
		 {
			 driver.switchTo().frame(nameOrId);
		 }
		 
		 public void switchToWindow(String nameOrId)
		 {
			 driver.switchTo().window(nameOrId);
		 }
		 
		 public void switchToParentFrame()
		 {
			 driver.switchTo().parentFrame();
		 }
		 
		 public void switchToDefaultContent()
		 {
			 driver.switchTo().defaultContent();
		 }
		 
		 public void switchToWindow()
		 {
			 String currentWindow= driver.getWindowHandle();
			 
			log.info("currentWindow : " + currentWindow);
			 
			 String window=null;
			 
			 Set<String> windows=driver.getWindowHandles();
			 
			 for (String string : windows) {
				 
				 System.out.println("Window : " + string);
				
			  }
			 
			Iterator<String> iterator = windows.iterator();
			
			while(iterator.hasNext())
			{
			    window=iterator.next();
			     
				if(!currentWindow.equals(window)) break;
				  
			}
			 
			driver.switchTo().window(window);
			
			log.info("window: " + window.equals(window));
			
			log.info("currentWindow == window: " + window.equals(currentWindow));
			 		 
		 }
		 
		 public void printWindowHanldes()
		 {
		
			 
			 Set<String> windows=driver.getWindowHandles();
			 
			 for (String window : windows) {
				 
				 System.out.println("Window : " + window);
				 
				 driver.switchTo().window(window);
				 
				 System.out.println(" driver.getCurrentUrl() : "+ driver.getCurrentUrl());  
				
			  }
			 
		
			 
			//driver.switchTo().window(window);
			
		
		 }
		 
		 public Set<String> getCurrentUrlFromWindowHanldes()
		 {
			 
			 Set<String> currentUrl= new HashSet<String>();
			 
		
			 
			 Set<String> windows=driver.getWindowHandles();
			 
			 for (String window : windows) {
				 
				 driver.switchTo().window(window);
				 
				 currentUrl.add(driver.getCurrentUrl());  
				
			  }
			 
		return currentUrl;
		 }
		 
		public boolean isCorrectCurrentUrl(Set<String> urls, String  url) {
			 
			 return urls.contains(url)		;
			 
		 }
		 
		
		 public String getCurrentWindow()
		 {
		
			 return driver.getWindowHandle();
		 }
	

}
