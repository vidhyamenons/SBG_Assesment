package util;

import org.json.JSONArray;
import org.json.JSONObject;

public class Payload extends Util {

	public static String fixturePayload(String id, String hometeam, String awayteam) {	

	
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("fixtureId", id);
		 
		 JSONObject fixtureStatus = new JSONObject();
		 fixtureStatus.put("displayed", false);
		 fixtureStatus.put("suspended", true); 
		 
		 requestParams.put("fixtureStatus", fixtureStatus);
		 
		 JSONObject footballFullState = new JSONObject();
		 footballFullState.put("homeTeam", hometeam);
		 footballFullState.put("awayTeam", awayteam); 
		 footballFullState.put("finished", false);
		 footballFullState.put("gameTimeInSeconds", 3676); 
		 
		 JSONObject goals = new JSONObject();
		 JSONArray goals_array = new JSONArray();
		 JSONObject goals_object = new JSONObject();
		 goals_object.put("id", 560617); 
		 goals_object.put("clockTime", 788);
		 goals_object.put("confirmed", true); 
		 goals_object.put("ownGoal", false);
		 goals_object.put("penalty", true); 
		 goals_object.put("period", "FIRST_HALF");
		 goals_object.put("playerId", 560617); 
		 goals_object.put("teamId", 1); 
		 
		 goals_array.put(goals_object);
		 
		 footballFullState.put("goals", goals_array);
		 
		 JSONArray possibles = new JSONArray();
		 JSONArray corners = new JSONArray();
		 JSONArray redCards = new JSONArray();
		 JSONArray yellowCards = new JSONArray();
		 
		 footballFullState.put("period", "SECOND_HALF"); 
		 footballFullState.put("possibles", possibles); 
		 footballFullState.put("corners", corners); 
		 footballFullState.put("redCards", redCards); 
		 footballFullState.put("yellowCards", yellowCards); 
		 footballFullState.put("startDateTime", "2018-03-20T10:49:38.655Z"); 
		 footballFullState.put("started",true); 
		 
		 JSONObject teams1 = new JSONObject();
		 teams1.put("association", "HOME");
		 teams1.put("name", hometeam);
		 teams1.put("teamId", "HOME");
		 JSONObject teams2 = new JSONObject();
		 teams2.put("association", "AWAY");
		 teams2.put("name", awayteam);
		 teams2.put("teamId", "AWAY");
		 
		 JSONArray teams_array = new JSONArray();
		 teams_array.put(teams1);
		 teams_array.put(teams2);
		 
		 footballFullState.put("teams", teams_array);
		 requestParams.put("footballFullState", footballFullState);
		 return requestParams.toString();
		 
					

}
}


 
