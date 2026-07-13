package com.joshifam.stripeAPIAutomation.Tests;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.joshifam.stripeAPIAutomation.ApiSetUp.APISetUp;

public class Sandbox extends APISetUp{

	@Test
	public static void test() {
		// TODO Auto-generated method stub
	
		//System.out.println(APISetUp.baseDirectory+ APISetUp.cp.getTestReportFilePath() + APISetUp.cp.getTestReportName());
		System.out.println(baseDirectory);
		System.out.println(cp.getTestReportFilePath());
		System.out.println(cp.getTestReportName());
		System.out.println(cp.getbasePath());
		Assert.assertTrue(true);
		}

}
