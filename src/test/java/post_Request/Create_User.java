package post_Request;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Rest_Utitls.ExcelDataConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create_User {
	public ExcelDataConfig excel;
	public Response resp;
	@Test
	public void createUser_Test() throws IOException
	{
		ExcelDataConfig excel=new ExcelDataConfig("D:\\Personal\\API_Automation_Testing\\API_List (1).xlsx");
		RestAssured.baseURI=excel.getData("Sheet1", 5,0);
		RequestSpecification httpRequest=RestAssured.given();
		resp=httpRequest.get(excel.getData("Sheet1", 5, 0));
		httpRequest.header("Content-Type","application/json");
		//request.auth().basic("admin", "admin321");
		JSONObject json=new JSONObject();
		json.put(excel.getData("Sheet1", 5, 2),excel.getData("Sheet1", 5, 3));
		json.put(excel.getData("Sheet1", 6, 2),excel.getData("Sheet1", 6, 3));
		httpRequest.body(json.toJSONString());
		Response resp=httpRequest.post(excel.getData("Sheet1", 5, 0));
		//Response resp=httpRequest.put(excel.getData("Sheet1", 5, 0));
		//Response resp=httpRequest.delete(excel.getData("Sheet1", 5, 0));
	    //Response resp=httpRequest.patch(excel.getData("Shhet1", 5, 0));
	   int code=resp.getStatusCode();
	   System.out.println("Status code is=" +code);
	   String statusline=resp.getStatusLine();
		System.out.println("Status line of Customer Login=" +statusline);
		//Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		System.out.println("Customer Register Request Method ="+excel.getData("Sheet1", 5, 1));
		System.out.println("Customer Register Post BodyData="+resp.getBody().asString());
	}



}
