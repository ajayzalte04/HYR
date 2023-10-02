package com.qa.utilLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.testBase.TestBase;

public class ListnerImp extends TestBase implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Successful");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Successful");
		Uitility.photoCapture("Dropdown", driver);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test started Successfuly");
	}

}
