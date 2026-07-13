package com.joshifam.stripeAPIAutomation.TestUtils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.Sources;

//"system:properties" instructs the framework to look at your Maven -D flags first!
/*@Sources({
"system:properties",
"classpath:configFiles/config.properties"
})*/
@Sources("classpath:configFiles/key.properties")

public interface KeyProperties extends Config{
	@Key("secretKey")
	String getsecretKey();
	

}
