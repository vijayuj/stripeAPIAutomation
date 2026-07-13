package com.joshifam.stripeAPIAutomation.ApiSetUp;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Paths;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.joshifam.stripeAPIAutomation.TestUtils.CommonUtils;
import com.joshifam.stripeAPIAutomation.TestUtils.ConfigProperties;
import com.joshifam.stripeAPIAutomation.TestUtils.ExcelReader;
import com.joshifam.stripeAPIAutomation.TestUtils.ExtentManager;

import io.restassured.RestAssured;
import io.restassured.specification.*;

public class APISetUp {

	public static ConfigProperties cp = ConfigFactory.create(ConfigProperties.class);
	public static String baseDirectory = System.getProperty("user.dir");

	public static ExcelReader excel;

	public static ExtentReports extentReport;
	public static ThreadLocal<ExtentTest> classLevelLog = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testLevelLog = new ThreadLocal<ExtentTest>();
	public static ExtentTest test = null;

	protected static RequestSpecification getRequestSpecification() {
		return RestAssured.given().auth().basic(cp.getSecretKeys(), "");
	}

	@BeforeSuite
	public static void beforeSuite() {

		/*
		 * Archiving Test Report
		 */

		CommonUtils.archiveReport();

		/*
		 * excel = new ExcelReader(Paths.get(baseDirectory, cp.getTestData()).toFile());
		 * 
		 * 
		 * File testReport = Paths.get(baseDirectory, cp.getTestReportFilePath(),
		 * cp.getTestReportName()).toFile(); // ✅ Converted to File
		 * 
		 * extentReport = ExtentManager.GetExtent(testReport);
		 * 
		 */

		System.out.println("\n 1. BEFORE SUITE Starting the Test Execution now \n");
		RestAssured.baseURI = cp.getbaseURL();
		RestAssured.basePath = cp.getbasePath();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(
				"\n 2. BEFORE TEST TAG log before any of the Tests get executed." + "We are connecting to database \n");

	}

	@BeforeClass
	public void beforeClass(ITestContext context) {
		System.out.println("\n 3. BEFORE CLASS log from " + context.getClass().getSimpleName()
				+ " before executing any tests in here \n");
		/*
		 * ExtentTest classLevelTest =
		 * extentReport.createTest(getClass().getSimpleName());
		 * classLevelLog.set(classLevelTest);
		 */
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("\n 4. BEFORE TEST log before " + method.getName() + " test begun \n");
		/*
		 * test = classLevelLog.get().createNode(method.getName());
		 * testLevelLog.set(test);
		 */
	}

	@AfterMethod
	public void afterMethod(Method method, ITestResult result) {
		System.out.println("\n 5. AFTER TEST logging after " + result.getMethod().getMethodName() + " test ended \n");
		/*
		 * switch (result.getStatus()) { case ITestResult.SUCCESS: Markup mp1 =
		 * MarkupHelper.createLabel(result.getMethod().getMethodName(),
		 * ExtentColor.GREEN); testLevelLog.get().pass(mp1); // Your custom logic for
		 * pass break; case ITestResult.FAILURE: System.out.println("Test Failed: " +
		 * result.getName()); System.out.println("Reason: " +
		 * result.getThrowable().getMessage()); Markup mf1 =
		 * MarkupHelper.createLabel(result.getMethod().getMethodName()+" FAILED",
		 * ExtentColor.RED); Markup mf2 =
		 * MarkupHelper.createLabel(result.getThrowable().getMessage(),
		 * ExtentColor.RED); testLevelLog.get().fail(mf1); testLevelLog.get().fail(mf2);
		 * 
		 * 
		 * break; case ITestResult.SKIP: System.out.println("Test Skipped: " +
		 * result.getName()); break;
		 * default:System.out.println("Unknown Test Status encountered."); break; }
		 */
	}

	@AfterClass
	public void afterClass(ITestContext context) {
		System.out.println("\n 6. AFTER CLASS log from " + context.getClass().getSimpleName()
				+ " before executing any tests in here \n");

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
