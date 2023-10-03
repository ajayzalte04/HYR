package com.qa.pageLayer;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;
import com.qa.utilLayer.Uitility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google extends TestBase {
	
	public Google()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//textarea[@class='gLFyf']")
	private	WebElement googleSearch;
	
	public void search(String actress) throws InterruptedException
	{
		logger=Logger.getLogger("Selenium Practice");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get("https://www.google.com/");
		logger.info("google search start successfuly");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    logger.info("timeout provided successfuly");
	    
	    
	    
	    googleSearch.sendKeys(actress+Keys.ENTER);
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//div[@class='CIVrJb oLJ4Uc']/child::img[@id='rimg_3']")).click();
	    driver.findElement(By.xpath("//img[@class='r48jcc pT0Scc iPVvYb']")).click();
	    Thread.sleep(5000);
	    Uitility.photoCapture(actress, driver);
	    

	    
	}
}
