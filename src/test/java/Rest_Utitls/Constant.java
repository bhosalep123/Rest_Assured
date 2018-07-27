package Rest_Utitls;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constant {
	public static String url="";
	public static String more_Categories=" ";
	public static String pramotion_Product="";
	public static String T_Search="";
	public static String Cust_log="";
	public static String getMeasurement="";
	public static void read_Constant()
	{
		try {
			FileInputStream fis=new FileInputStream("D:\\Personal\\API_Automation_Testing\\Object.properties");
			Properties pro=new Properties();
			pro.load(fis);
			url=pro.getProperty("categories");
			more_Categories=pro.getProperty("Explore_Categories");
			pramotion_Product=pro.getProperty("Pramotion");
			T_Search=pro.getProperty("Tailor_Search");
			Cust_log=pro.getProperty("login");
			getMeasurement=pro.getProperty("GetTypeOfMeasurement");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
