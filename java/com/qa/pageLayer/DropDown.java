package com.qa.pageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testBase.TestBase;
import com.qa.utilLayer.Uitility;

public class DropDown extends TestBase{

	public DropDown()
	{
		PageFactory.initElements(driver, this);
	}
	
	//rollover_seleniumPractice
	@FindBy(xpath="//li[@class='parent']/child::a[text()='Selenium Practice']")
	private WebElement selPractice;
	public void rollover_seleniumPractice() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(selPractice).build().perform();
		logger.info("rollover_seleniumPractice successfuly");
		Thread.sleep(2000);
	}
	
	//clickdropDown
	@FindBy(xpath="//li/child::a[text()='Dropdowns']")
	private WebElement dropDown;
	public void clickdropDown() throws InterruptedException
	{
		dropDown.click();
		logger.info("clicked dropDown successfuly");
	}
	
	//advertiseFrame
	@FindBy(xpath="//iframe[@id='aswift_5']")
	private WebElement frame1;
	public void adFrame() throws InterruptedException
	{
		Thread.sleep(2000);
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementLocated());
		driver.switchTo().frame(frame1);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='ad_iframe']")));
		try {
		driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		logger.info("adFrame closed successfuly");
		
	}
	
	//course_dropDown
		@FindBy(xpath="//select[@id='course']")
		private WebElement course_dropDown;
		public void course_dropDown()
		{
			Select s=new Select(course_dropDown);
			s.selectByVisibleText("Python");
			logger.info("course language selected successfuly");
			WebElement course=s.getFirstSelectedOption();
			logger.info(course.getText());
			
		}
		
		//IDE_dropDown
				@FindBy(xpath="//select[@id='ide']")
				private WebElement ide_dropDown;
				public void ide_dropDown()
				{
					Select s=new Select(ide_dropDown);
					Actions act_ide=new Actions(driver);
					s.selectByVisibleText("NetBeans");
					logger.info("ide NetBeans selected successfuly");
					WebElement ide_NetBeans=s.getFirstSelectedOption();
					logger.info(ide_NetBeans.getText());
					s.selectByVisibleText("Eclipse");
					logger.info("ide Eclipse selected successfuly");
					WebElement ide_Eclipse=s.getFirstSelectedOption();
					logger.info(ide_Eclipse.getText());
					
				}
}
