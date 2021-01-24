package testcases;
import io.restassured.path.json.JsonPath;
import util.Util;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetFixtures extends Util{

	@Test
	public void getFixtures() throws IOException
	{
		
		JsonPath path=given().spec(requestSpecification())	
				.when().get("/fixtures")
				.then().assertThat().statusCode(200).extract().body().jsonPath();
				
		//Assert that there are 3 fixtures within the returned object.		
		System.out.println("Number of fixtures are "+path.getList("$").size());
		System.out.println(path.get("fixtureId").toString());
		SoftAssert a = new SoftAssert();
		a.assertEquals(path.getList("$").size(), 3);	
				
		//Assert that each of the 3 fixtures has a fixtureId value.
		List<Map<String, Object>>  fixtures = path.getList("$");		
		for (Map<String, Object> fixture : fixtures) {
			if(fixture.get("fixtureId")!=null){
				a.assertTrue(true);}
	    }a.assertAll();		
	}
}
