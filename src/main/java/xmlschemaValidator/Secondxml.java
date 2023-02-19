package xmlschemaValidator;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.API.utils.PropertiesClass;

import io.restassured.RestAssured;
import io.restassured.internal.matcher.xml.XmlXsdMatcher;

import static io.restassured.RestAssured.*;

public class Secondxml extends PropertiesClass{

	@Test
	public void menuValidate() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "/XMLSchema/menu.xsd");
		
		RestAssured.baseURI = PropertiesClass.setMenu_baseURI();
		RestAssured.basePath = PropertiesClass.setMenu_basePath();

		given()
			.accept("Application/xml")
			.header("application","xml")
		.when()
			.post()
		.then()
			.assertThat()
			.body(XmlXsdMatcher.matchesXsd(file))
			.log()
			.all();  
		
	}

}
