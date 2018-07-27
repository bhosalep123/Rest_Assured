package getRequest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import Rest_Utitls.Constant;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMeasurment {
	//public static String categories_list="";
	@Test(priority=0)
	public void getProductMeasurement() throws IOException
	{
		
		//RestAssured is the class is used to setup a request with the specified base URI
		RestAssured.baseURI=Constant.getMeasurement;
		
		//Request Spacification is used to modifiy the request like adding headers and adding authentication details.
		RequestSpecification httpRequest=RestAssured.given();
		Response resp=httpRequest.get(Constant.getMeasurement);
		int code=resp.getStatusCode();
		System.out.println("Explore Categories Response code is="+code);
		Assert.assertEquals(code,200);
		String line=resp.getStatusLine();
		System.out.println("Status line of Explorer Categories Listing "+line);
		Assert.assertEquals(line, "HTTP/1.1 200 OK"); 
	}
	@Test(priority=1)
	public void expolre_CategoriesList_Body()
	{
		Response resp1=RestAssured.get(Constant.getMeasurement);
		String data1=resp1.getBody().asString();
		System.out.println("Explorer Categories of Body Data"+data1);
		System.out.println("Responce time of Explorer Categories List"+resp1.getTime());
	}


}
