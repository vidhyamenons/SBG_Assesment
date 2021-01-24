package testcases;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.path.json.JsonPath;
import util.Payload;
import util.Util;

public class StoreFixture extends Util {

	@Test(dataProvider="NewFixtureData")
	public void storeFixture(String id, String hometeam, String awayteam) throws IOException, InterruptedException, TimeoutException
	{
			//POST a new fixture
			given().spec(requestSpecification()).header("Content-Type", "application/json")
						.body(Payload.fixturePayload(id,hometeam,awayteam)).when().post("/fixture")
						.then().assertThat().log().all().statusCode(202).extract().response().asString();
				
			//GET the new fixture and assert, within the teams array, that the first object has a teamId of 'HOME'.
			JsonPath path=null;
			String result=null;
			int i = 0;
		    while (i < 10) {
		    	path =given().spec(requestSpecification())	
				.when().get("/fixtures")
				.then().extract().body().jsonPath();
		         result = path.get("fixtureId").toString();
		        if (result.contains(id)) {
		            break;
		        } else {
		            TimeUnit.SECONDS.sleep(1);
		            ++i;
		            if (i == 10) {
		                throw new TimeoutException("Timed out after waiting for " + i + " seconds");
		            }
		        }
		    }
		    SoftAssert a=new SoftAssert();
			System.out.println(result);
			a.assertEquals(path.getString("footballFullState.teams[0].teamId[0]"), "HOME");
			a.assertAll();
	}		
		

	@DataProvider(name="NewFixtureData")
	public Object[][] getData()
	{
		Object[][] data=new Object[1][3];
		data[0][0]="4";
		data[0][1]="Liverpool";
		data[0][2]="Burnley";
	return data;
	}
}




