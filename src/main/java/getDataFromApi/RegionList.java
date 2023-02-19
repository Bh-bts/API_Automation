package getDataFromApi;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.util.List;
import io.restassured.response.Response;

/**
 * @author Bhavin.Thumar
 *
 */

public class RegionList {
	
	@Test
	public void getRegionList() {
		
		JSONObject Data = new JSONObject();
		Data.put("empno", "100999");
		Data.put("password", "Admin@1234");
		
		RestAssured.baseURI = "http://103.138.234.244:9067";
		RestAssured.basePath = "/api/Login/Login";
		
		Response res = (Response)
				
				given()
					.body(Data.toString())
				.when()
					.post();
		
		String getToken = res.getBody().asPrettyString();
		JsonPath jpath = new JsonPath(getToken);
		String token = jpath.get("data.tokenData").toString();	
		
		JSONObject Data1 = new JSONObject();
		Data1.put("countryID", "0");
		Data1.put("currentPage", "1");
		Data1.put("records", "10");
		Data1.put("stateID", "0");
		Data1.put("zoneID", "0");
		Data1.put("divisionCode", "");
		Data1.put("regionName", "");
		Data1.put("search", "");
		Data1.put("sortDirection", "");
		Data1.put("sortExpression", "");
		
		RestAssured.baseURI = "http://103.138.234.244:9067";
		RestAssured.basePath = "/api/Region/RegionList";
		
		Response res1 = (Response)
		
		given()
		.header("Authorization","Bearer "+token) 
			.body(Data1.toString())
		.when()
			.post();
		
		String a = res1.getBody().asPrettyString();
		JsonPath jsPath = new JsonPath(a);
		List<String> b = jsPath.getList("data.regionDetails.records.regionName");
		List<String> b1 = jsPath.getList("data.regionDetails.records.countryName");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < b.size(); i++) {
			
			sb.append(i).append(": ").append(b.get(i)).append(" " + b1.get(i)).append("\n");
			
		}
		
		String con = sb.toString();
		System.out.println(con);
	}

}
