package xmlschemaValidator;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.internal.matcher.xml.XmlXsdMatcher;
import static io.restassured.RestAssured.*;
import java.io.File;


public class Firstxml {
	
	
	@Test
	public void firstXML() {
		
		String projectpath = System.getProperty("user.dir");
		File file = new File(projectpath + "/XMLSchema/Course.xsd");
		
		RestAssured.baseURI = "https://run.mocky.io/v3";
		RestAssured.basePath = "/55889581-da52-4383-840e-bdf6dde19252";
		
		given()
			.contentType("application/xml")
			.header("Accept","application/xml")
		.when()
			.get()
		.then()
			.assertThat()
			.body(XmlXsdMatcher.matchesXsd(file))
			.statusCode(200)
			.log()
			.all();
		
	}

}
