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
	    String newReportName = sdf.format(new Date()) + "_" + oldreportName;
	    
	    String userDir = System.getProperty("user.dir");
	    
	    // Let Java construct the platform-safe paths
	    Path oldFile = Paths.get(userDir, "src", "test", "resources", "testReports", oldreportName);
	    Path newPath = Paths.get(userDir, "src", "test", "resources", "archivedTestReports", newReportName);
	    
	    // Ensure parent directories exist before creating files
	    try {
	        Files.createDirectories(newPath.getParent());
	        if (!Files.isRegularFile(oldFile)) {
	            Files.createFile(oldFile);
	        }
	        Files.move(oldFile, newPath, StandardCopyOption.REPLACE_EXISTING); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }   
	}

}
