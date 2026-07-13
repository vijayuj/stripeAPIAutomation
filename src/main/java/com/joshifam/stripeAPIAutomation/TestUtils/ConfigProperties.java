package com.joshifam.stripeAPIAutomation.TestUtils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

//"system:properties" instructs the framework to look at your Maven -D flags first!
/*@Sources({
 "system:properties",
 "classpath:configFiles/config.properties"
})*/
@Sources("classpath:configFiles/config.properties")
public interface ConfigProperties extends Config{
	
	@Key("secretKey")
	String getSecretKeys();
	
	@Key("baseURL")
	String getbaseURL();
	
	@Key("basePath")
	String getbasePath();
	
	@Key("env")
	String getenvironment();
	
	@Key("TestData")
	String getTestData();
	
	@Key("testReportName")
	String getTestReportName();
	
	@Key("testReportFilePath")
	String getTestReportFilePath();
	
	@Key("reportConfigFile")
	String getreportConfigFile();
}
