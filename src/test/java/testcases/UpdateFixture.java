package testcases;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.path.json.JsonPath;
import util.Payload;
import util.Util;

public class UpdateFixture extends Util {
	@Test(dataProvider="UpdateFixtureData")
	public void storeFixture(String hometeam, String awayteam) throws IOException, InterruptedException, TimeoutException
	{
		//PUT a fixture
		given().spec(requestSpecification()).header("Content-Type", "application/json")
		.body(Payload.fixturePayload(fixtureId(),hometeam,awayteam)).when().put("/fixture")
		.then().assertThat().log().all().statusCode(204).extract().body().jsonPath();
		
		JsonPath path=given().spec(requestSpecification())	
				.when().get("/fixture/"+fixtureId())
				.then().assertThat().statusCode(200).extract().body().jsonPath();
		
		//Assert that the relevant attributes in the fixture have changed.
		SoftAssert a=new SoftAssert();
		a.assertEquals(path.getString("footballFullState.homeTeam"), hometeam);
		a.assertEquals(path.getString("footballFullState.awayTeam"), awayteam);
		a.assertAll();
		
	}
	
	
	@DataProvider(name="UpdateFixtureData")
	public Object[][] getNewData()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="Leicester City";
		data[0][1]="Chelsea";
	return data;
	}
}
