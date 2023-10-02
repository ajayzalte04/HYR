package com.qa.pageLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testBase.TestBase;
import com.qa.utilLayer.Uitility;

public class Wait extends TestBase {
	public Wait()
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
		
		
		//clickWait
		@FindBy(xpath="//li/child::a[text()='Waits Practice']")
		private WebElement clickWait;
		public void clickWait() throws InterruptedException
		{
			clickWait.click();
			logger.info("clicked dropDown successfuly");
		}
		
		//advertiseFrame
		@FindBy(xpath="//iframe[@id='aswift_5']")
		private WebElement frame1;
		public void adFrame() throws InterruptedException
		{
			Thread.sleep(2000);
//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementLocated());
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
		
		//click_Textbox1
				@FindBy(xpath="//button[contains(text(),'Add Textbox1')]")
				private WebElement Textbox1;
				public void click_Textbox1() throws InterruptedException
				{
					Textbox1.click();
					logger.info("clicked Textbox1 successfuly");
				}
	//waitTextBox1
				@FindBy(xpath="//input[contains(@id,'txt1')]")
				private WebElement textbox;
				public void waitTextBox1() throws InterruptedException
				{
					WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'txt1')]")));
					logger.info("wait provided for textbox1 successfuly");
					textbox.sendKeys("AJ");
				}
				
	//click_Textbox2
				@FindBy(xpath="//button[contains(text(),'Add Textbox2')]")
				private WebElement Textbox2;
				public void click_Textbox2() throws InterruptedException
				{
					Textbox2.click();
					logger.info("clicked Textbox2 successfuly");
				}
	//waitTextBox2
				@FindBy(xpath="//input[contains(@id,'txt2')]")
				private WebElement textbox2;
				public void waitTextBox2() throws InterruptedException
				{
					WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(11));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'txt2')]")));
					logger.info("wait provided for textbox2 successfuly");
					textbox2.sendKeys("Zalte");
					
					
				}
}
