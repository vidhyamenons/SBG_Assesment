package testcases;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.path.json.JsonPath;
import util.Util;

public class DeleteFixture extends Util {
	@Test
	public void deleteFixture() throws IOException
	{
		
	//DELETE the new fixture
	 String id = fixtureId();	
	 given().spec(requestSpecification())
			.when().delete("/fixture/"+fixtureId())
			.then().assertThat().log().all().statusCode(204).extract().response().asString(); 
	
	//Assert that the fixture no longer exists
	 JsonPath path=given().spec(requestSpecification())	
				.when().get("/fixtures")
				.then().assertThat().statusCode(200).extract().body().jsonPath();
	 SoftAssert a = new SoftAssert();
				 
	  List<Map<String, Object>>  fixtures = path.getList("$");		
		for (Map<String, Object> fixture : fixtures) {
			if(fixture.get("fixtureId").toString().contains(id)){
				a.assertTrue(false);
				break;
			}
		}
				
	    a.assertAll();		
	}
}
	

