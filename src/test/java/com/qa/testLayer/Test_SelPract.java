package com.qa.testLayer;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pageLayer.DropDown;
import com.qa.pageLayer.Wait;
import com.qa.pageLayer.WindoHandle;
import com.qa.testBase.TestBase;

public class Test_SelPract extends TestBase {
	
	@Test(priority=2)
	public void TC01_DropDown() throws InterruptedException
	{
		dropDown=new DropDown();
		dropDown.rollover_seleniumPractice();
		dropDown.clickdropDown();
		dropDown.adFrame();
		dropDown.course_dropDown();
		dropDown.ide_dropDown();
	}
	
	@Test(priority=0)
	public void TC02_Wait() throws InterruptedException
	{
		wait=new Wait();
		wait.rollover_seleniumPractice();
		wait.clickWait();
		wait.adFrame();
		wait.click_Textbox1();
		wait.waitTextBox1();
		wait.click_Textbox2();
		wait.waitTextBox2();
		wait.click_Textbox2();
	}
	
	@Test
	public void TC03_WindoHandle() throws InterruptedException, IOException
	{
		windoHandle=new WindoHandle();
		windoHandle.rollover_seleniumPractice();
		
		windoHandle.click_WindoHandle();
		windoHandle.adFrame();
		//newWindow
//		windoHandle.open_new_window();
//		windoHandle.enter_name_childWindow("Rihan");
//		windoHandle.enter_lname_childWindow("Kapoor");
//		
//		//newTab_Alert
//		windoHandle.open_new_Tab();
//		windoHandle.newTab_simpleAlert();
//		windoHandle.Prompt_alert_newTab();
		
	    //Multiple Window
		windoHandle.open_Mult_Window();
		
	}
	
	

	

}
