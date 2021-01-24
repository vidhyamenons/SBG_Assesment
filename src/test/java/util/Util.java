package util;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Util {
	public  RequestSpecification req;
	public  RequestSpecification requestSpecification() throws IOException
	
	{

		if (req==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
			.addFilter(RequestLoggingFilter.logRequestTo(log))
			.addFilter(ResponseLoggingFilter.logResponseTo(log)).
	setContentType(ContentType.JSON).build();
	return req;
}
		return req;
	}
	public String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\util\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}
	
	public String fixtureId() throws IOException
	{
		
		ArrayList<String> array = new ArrayList<String>();
		JsonPath path=given().spec(requestSpecification())	
				.when().get("/fixtures")
				.then().assertThat().statusCode(200).extract().body().jsonPath();
		int i=0;
		List<Map<String, Object>>  fixtures = path.getList("$");		
		for (Map<String, Object> fixture : fixtures) {
			array.add(fixture.get("fixtureId").toString());
			i++;
		}
		
		return array.get(i-1);	
	}
	
}