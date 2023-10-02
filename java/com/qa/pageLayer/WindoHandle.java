package com.qa.pageLayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.testBase.TestBase;
import com.qa.utilLayer.Uitility;

public class WindoHandle extends TestBase {
	public WindoHandle()
	{
		PageFactory.initElements(driver, this);
	}
	
	//rollover_seleniumPractice
		@FindBy(xpath="//li[@class='parent']/child::a[text()='Selenium Practice']")
		private WebElement selPractice;
		public void rollover_seleniumPractice() throws InterruptedException
		{
			Actions act=new Actions(driver);
			act.moveToElement(selPractice).build().perform();;
			logger.info("rollover_seleniumPractice successfuly");
			Thread.sleep(2000);
		}
		
		//click_WindoHandle
	    @FindBy(xpath="//li/child::a[text()='Window Handles']")
		private WebElement WindoHandle;
		public void click_WindoHandle() throws InterruptedException
		{
				WindoHandle.click();
				logger.info("clicked window handle tab successfuly");
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
			logger.info("ad closed  successfuly");
			
		}
//open_new_window
		public String p_window;
		public String c_window;
	    @FindBy(xpath="//button[@id='newWindowBtn']")
		private WebElement new_window;
		public void open_new_window() throws InterruptedException
		{
			new_window.click();
			logger.info("clicked new_window  successfuly");
			Thread.sleep(2000);
			Set<String> ids=driver.getWindowHandles();
			Iterator<String> itr=ids.iterator();
			p_window=itr.next();
			logger.info(p_window);
			c_window=itr.next();
			logger.info(c_window);
			driver.switchTo().window(c_window);
			driver.manage().window().maximize();
		}
		//enter_name_childWindow
		@FindBy(xpath="//input[@id='firstName']")
		private WebElement name_childWindow;
		public void enter_name_childWindow(String fname)
		{
			name_childWindow.sendKeys(fname);
			logger.info(fname);
		}
		//enter_lname_childWindow
				@FindBy(xpath="//input[@id='lastName']")
				private WebElement lname_childWindow;
				public void enter_lname_childWindow(String lname)
				{
					lname_childWindow.sendKeys(lname);
					logger.info(lname);
					driver.close();
					driver.switchTo().window(p_window);
					System.out.println((driver.getTitle()));
					if(driver.getTitle().equals("Window Handles Practice - H Y R Tutorials"))
					   {
						   Assert.assertTrue(true);
						   logger.info("***Window Handles Test Passed***");
					   }
					   else
					   {
							   Assert.assertTrue(false);
							   logger.info("***Window Handles Test Failed***");
							  
					   }
					   
				}
//open_new_Tab
				public String p_Tab;
				public String c_Tab;
			    @FindBy(xpath="//button[@id='newTabBtn']")
				private WebElement new_Tab;
				public void open_new_Tab() throws InterruptedException
				{
					Thread.sleep(2000);
					new_Tab.click();
					logger.info("clicked new window tab successfuly");
					Set<String> ids=driver.getWindowHandles();
					Iterator<String> itr=ids.iterator();
					p_Tab=itr.next();
					logger.info(p_Tab);
					c_Tab=itr.next();
					logger.info(c_Tab);
					driver.switchTo().window(c_Tab);
					
				}
				
//Handle_newTab_simpleAlert
				@FindBy(xpath="//button[@id='alertBox']")
				private WebElement alert_newTab;
				public void newTab_simpleAlert() throws InterruptedException
				{
					Thread.sleep(3000);
					alert_newTab.click();
					logger.info("clicked alert_newTab tab successfuly");
					driver.switchTo().alert().accept();
					logger.info("handled simple alert successfuly");
				}
//Handle_newTab_promptAlert
				@FindBy(xpath="//button[@id='promptBox']")
				private WebElement promptBox;
				public void Prompt_alert_newTab() throws InterruptedException
				{
					Thread.sleep(3000);
					promptBox.click();
					logger.info("clicked alert_newTab tab successfuly");
					try
					{
					String altText=driver.switchTo().alert().getText();
					logger.info(altText);
					driver.switchTo().alert().accept();
					logger.info("prompt alert handled");
					}
					catch(Exception e)
					{
						e.printStackTrace();
						logger.info("prompt alert not handled");
					}
					driver.close();
					   
				}
				
//open_Mult_Window
				public String p_Windows;
				public String c_Windows;
			    @FindBy(xpath="//button[@id='newWindowsBtn']")
				private WebElement Mult_Window;
				public void open_Mult_Window() throws InterruptedException, IOException
				{
					Thread.sleep(2000);
					Mult_Window.click();
					logger.info("clicked multiple window tab successfuly");
					Set<String> ids=driver.getWindowHandles();
					int noWindows=ids.size();
//				
					List<String> list=new ArrayList<String>(ids);
					int i=0;
					while(i<noWindows)
					{
						logger.info(list.get(i).toString());
						String title=driver.getTitle();
						logger.info(" "+title);
						String p1=list.get(0);
						String c1=list.get(1);
						String c2=list.get(2);
						
						if(list.get(i).equals(p1))
						{
							logger.info("I am parent window");
							driver.manage().window().maximize();
							try {
							WebElement xyz=driver.findElement(By.xpath("//select[@id='selectnav2']"));
							xyz.click();
							Select s=new Select(xyz);
							s.selectByVisibleText("Contact");
							logger.info(s.getFirstSelectedOption().getText());
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							
						}
						else if(list.get(i).equals(c1))
						{
							logger.info("I am child window 1");
							logger.info("child window 1 closed");
						}
						else if(list.get(i).equals(c2))
						{
							logger.info("I am child window 2");
							driver.switchTo().window(c2);	
							logger.info("child window 2 closed");
							
							
						}
						else
						{
							logger.info("No window found");
						}
						i++;
					}
					
				}
				
				
		
		
}
