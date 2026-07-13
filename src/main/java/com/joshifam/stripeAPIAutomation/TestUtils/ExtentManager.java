package com.joshifam.stripeAPIAutomation.TestUtils;

import java.io.IOException;

import com.joshifam.stripeAPIAutomation.ApiSetUp.APISetUp;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	//private static ExtentTest test;
	private static ExtentSparkReporter htmlReporter;
	//private static String filePath = "./extentreport.html";


	public static ExtentReports GetExtent(String filePath) {
		if (extent != null) {
			return extent;
		} else {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter(filePath));
			extent.setSystemInfo("Host Name", "Vijay Joshi");
			
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			return extent;
		}
	}

	public static ExtentSparkReporter getHtmlReporter(String filePath) {

		htmlReporter = new ExtentSparkReporter(filePath);
		/*htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle(" Automation Report");
		htmlReporter.config().setReportName("Automation");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);*/
		
	//	htmlReporter.setAppendExisting(false);
		try {
			htmlReporter.loadXMLConfig(APISetUp.baseDirectory+APISetUp.cp.getreportConfigFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return htmlReporter;
	}

}
