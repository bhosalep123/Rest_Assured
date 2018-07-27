package put_Request;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import Rest_Utitls.ExcelDataConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update_User {
	public ExcelDataConfig excel;
	public Response resp;
	@Test
	public void update_userTest()
	{
		ExcelDataConfig excel=new ExcelDataConfig("D:\\Personal\\API_Automation_Testing\\API_List (1).xlsx");
		RestAssured.baseURI=excel.getData("Sheet2", 1, 0);
		RequestSpecification httpRequest=RestAssured.given();
		resp=httpRequest.get(excel.getData("Sheet1", 1, 0));
		httpRequest.header("Content-Type","application/json");
		JSONObject json=new JSONObject();
		json.put(excel.getData("Sheet2", 1, 2), excel.getData("Sheet2", 1, 3));
		json.put(excel.getData("Sheet2", 2, 2), excel.getData("Sheet2", 2, 3));
		httpRequest.body(json.toJSONString());
		Response resp=httpRequest.put(excel.getData("Sheet2", 1, 0));
		int code=resp.getStatusCode();
		System.out.println("Status code is=" +code);
		String statusline=resp.getStatusLine();
		System.out.println("Status line of Customer Login=" +statusline);
			//Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		System.out.println("Request Put Method ="+excel.getData("Sheet2", 1, 1));
		System.out.println("Request Put BodyData="+resp.getBody().asString());
		
		
	}

}
