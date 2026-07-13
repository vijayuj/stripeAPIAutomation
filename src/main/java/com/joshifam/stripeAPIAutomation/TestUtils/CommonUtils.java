package com.joshifam.stripeAPIAutomation.TestUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
	
	public static void archiveReport() {
		String oldreportName = "TestReport.html";
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_dd_hh_mm_ss");
		String newReportName = sdf.format(new Date())+"_"+oldreportName;
		
		String oldresourcePath = "/src/test/resources/testReports/";
		String newresourcePath = "/src/test/resources/archivedTestReports/";
		
		Path oldFile = Paths.get(System.getProperty("user.dir")+oldresourcePath+oldreportName);
		Path newPath = Paths.get(System.getProperty("user.dir")+newresourcePath+newReportName);
		
		if(!Files.isRegularFile(oldFile)) {
			  try { Files.createFile(oldFile); }
			  catch (IOException e) { // TODO Auto-generated catch block 
			  e.printStackTrace();
			  }			 
		 }
		  try { Files.move(oldFile, newPath, StandardCopyOption.ATOMIC_MOVE); }
		  	catch (IOException e) { // TODO Auto-generated catch block 
			  e.printStackTrace(); 
		  	}	
	}

}
