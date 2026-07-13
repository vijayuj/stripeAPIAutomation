package com.joshifam.stripeAPIAutomation.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.joshifam.stripeAPIAutomation.ApiSetUp.APISetUp;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyFirstTest extends APISetUp {

	@Test
	public static void testAPI1() {
		// TODO Auto-generated method stub

		String endPoint = "customers?limit=3";
/*		
		Response create = RestAssured.given()
			    .auth().basic(secretKey, "")
			    .formParam("email", "test@example.com")
			    .post("customers");

			create.prettyPrint();
			*/
			
		
		System.out.println("\n ==========Post Request completed========= \n");
		
		Response response =  getRequestSpecification()
				.get(endPoint);
		//System.out.println(response.prettyPrint());
		System.out.println("Status: " + response.getStatusCode());
		System.out.println("All footers: " + response.path("data.invoice_settings.footer"));
		System.out.println("ID: " + response.jsonPath().get("data.findAll{it.id.toLowerCase().startsWith('cus_')}.size()"));
		System.out.println("Some filtering: " + response.path("data.invoice_settings.findAll{it.footer=null}.custom_fields"));
		//System.out.println("Body: " + response.asString());
		
		  Assert.assertEquals(response.jsonPath().get(
		  "data.findAll{it.id.toLowerCase().startsWith('cus_')}.size()!=3"), false);
		  Assert.assertEquals(response.jsonPath().getInt(
		  "data.findAll{it.id.toLowerCase().startsWith('cus_')}.size()"), 3);
		 
	}

}
