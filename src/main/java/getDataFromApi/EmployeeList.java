package getDataFromApi;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EmployeeList {

	@Test
	public void empList() throws FileNotFoundException {

		RestAssured.baseURI = "http://103.138.234.244:9067";
		RestAssured.basePath = "/api/Login/Login";

		JSONObject Data = new JSONObject();
		Data.put("empno", "100999");
		Data.put("password", "Admin@1234");

		Response res = (Response)

		given().body(Data.toString()).when().post();

		String token = res.getBody().asPrettyString();

		JsonPath js = new JsonPath(token);
		String getToken = js.get("data.tokenData");

		RestAssured.baseURI = "http://103.138.234.244:9067";
		RestAssured.basePath = "/api/Employee/GetEmployeeList";

		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/src/main/java/getDataFromApi/employListAPi.json");
		FileReader reader = new FileReader(file);
		JSONTokener jt = new JSONTokener(reader);
		JSONObject Data1 = new JSONObject(jt);

		Response res1 = (Response)

		given().header("Authorization", "Bearer " + getToken).body(Data1.toString()).when().post();

		String desig = res1.getBody().asPrettyString();
		JsonPath jsp = new JsonPath(desig);

		List<String> a = jsp.get("data.employeeList.designationName");

		StringBuilder sb = new StringBuilder();

		for (String aq : a) {

			String aqs = aq.toString();

			for (int i = 0; i < aqs.length(); i++) {

				sb.append(i).append(": ").append(a.get(i)).append("\n");

			}

			System.out.println(sb.toString());

		}

	}

}
