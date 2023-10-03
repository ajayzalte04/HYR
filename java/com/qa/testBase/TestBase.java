package com.qa.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.qa.pageLayer.DropDown;
import com.qa.pageLayer.Google;
import com.qa.pageLayer.Wait;
import com.qa.pageLayer.WindoHandle;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Logger logger;
	public DropDown dropDown;
	public Wait wait;
	public WindoHandle windoHandle;
	public Google google;
	Properties prop;
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		//config.properties for configuration
		String file_path="./config.properties";
		File src=new File(file_path);
		FileInputStream fis=new FileInputStream(src);
		prop=new Properties();
		prop.load(fis);
		
		String br=prop.getProperty("browser");
		String baseURL=prop.getProperty("baseUrl");
		
		logger=Logger.getLogger("Selenium Practice");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Ganpati Bappa Morya");
		
		if(br.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	    driver=new ChromeDriver(options);
	    logger.info("browser start successfuly");
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("browser start successfuly");
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			logger.info("browser start successfuly");
		}
		else
		{
			logger.info("enter proper browser name");
		}
	    driver.manage().window().maximize();
	    logger.info("browser maximized successfuly");
		driver.manage().deleteAllCookies();
		logger.info("browser cookies deleted successfuly");
//		driver.get(baseURL);
//		logger.info("url start successfuly");
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	    logger.info("timeout provided successfuly");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
