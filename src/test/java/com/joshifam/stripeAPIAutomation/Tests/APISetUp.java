package com.joshifam.stripeAPIAutomation.Tests;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;
import com.joshifam.stripeAPIAutomation.TestUtils.ConfigProperties;

import io.restassured.RestAssured;
import io.restassured.specification.*;


public class APISetUp {
	
	protected static ConfigProperties cp=  ConfigFactory.create(ConfigProperties.class);
	
	protected static RequestSpecification getRequestSpecification() {
		return RestAssured
				.given()
				.auth()
				.basic(cp.getSecretKeys(), "");		
	}
	
	@BeforeSuite
	public static void beforeSuite() {
		String envv = System.getProperty("environment");
		System.out.println("\n 1. BEFORE SUITE Starting the Test Eexcution now \n"+System.getProperty("baseURI")+"\n"+envv);
		RestAssured.baseURI = cp.getbaseURL();
		RestAssured.basePath = cp.getbasePath();
		
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("\n 2. BEFORE TEST TAG log before any of the Tests get executed."
				+ "We are connecting to database \n");
	
	}
	@BeforeClass
	public void beforeClass(ITestContext context) {
		System.out.println("\n 3. BEFORE CLASS log from "+context.getClass().getSimpleName()+" before executing any tests in here \n");
	
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("\n 4. BEFORE TEST log before "+method.getName()+" test begun \n");
	
	}
	
	@AfterMethod
	public void afterMethod(Method method, ITestResult result) {
		System.out.println("\n 5. AFTER TEST logging after "+result.getMethod().getMethodName()+" test ended \n");	
	}
	
	@AfterClass
	public void afterClass(ITestContext context) {
		System.out.println("\n 6. AFTER CLASS log from "+context.getClass().getSimpleName()+" before executing any tests in here \n");
	
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("\n 7. AFTER TEST TAG We are dis-connecting the database \n");
	
	}
		
	@AfterSuite
	public static void afterSuite() {
		System.out.println("\n 8. AFTER SUITE Ending the Test Eexcution now \n");	
	}
	
	
}
