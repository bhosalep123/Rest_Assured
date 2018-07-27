package post_Request;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import Rest_Utitls.ExcelDataConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo_Login {
	public ExcelDataConfig excel1;
	public Response resp1;
	@Test
	public void custSocilogin_Test() throws IOException
	{
	ExcelDataConfig excel=new ExcelDataConfig("D:\\Personal\\API_Automation_Testing\\API_List (1).xlsx");
	RestAssured.baseURI=excel.getData("Sheet1", 3,0);
	RequestSpecification httpRequest=RestAssured.given();
	resp1=httpRequest.get(excel.getData("Sheet1", 3, 0));
	httpRequest.header("Content-Type","application/json");
	//request.auth().basic("admin", "admin321");
	JSONObject json=new JSONObject();
	json.put(excel.getData("Sheet1", 3, 2),excel.getData("Sheet1", 3, 3));
	json.put(excel.getData("Sheet1", 4, 2),excel.getData("Sheet1", 4, 3));
	//json.put("name", "sagar n");
	//json.put("email", "sagar.nangare@wwindia.com");
	//json.put("social_type", "facebook");
	//json.put("social_login_id", "12350");
	httpRequest.body(json.toJSONString());
   Response resp=httpRequest.post(excel.getData("Sheet1", 3, 0));
   int code=resp.getStatusCode();
   System.out.println("Status code is" +code);
   String statusline=resp.getStatusLine();
	System.out.println("Status line of Customer Login=" +statusline);
	//Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	System.out.println("Customer Social Login Post Request Body ="+excel.getData("Sheet1", 3,1));
	System.out.println("Customer Social Login Post Method "+resp.getBody().asString());
}

}
