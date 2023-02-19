package praticePacakge;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PostReq_POJO1 {

	String empno, isFromMobile,password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getIsFromMobile() {
		return isFromMobile;
	}

	public void setIsFromMobile(String isFromMobile) {
		this.isFromMobile = isFromMobile;
	}

	@Test
	public void roleViseMenu() throws IOException {
		
		RestAssured.baseURI = "http://103.138.234.244:9067";
		RestAssured.basePath = "/api/Login/Login";
		
		PostReq_POJO1 Data = new PostReq_POJO1();
		Data.setEmpno("100999");
//		Data.setIsFromMobile("false");
		Data.setPassword("Admin@1234");
		
		Response  res = (Response)
		
		given()
			.body(Data)
		.when()
			.post();
		
		//System.out.println(res.getBody().asPrettyString());
		
		String json = res.getBody().asPrettyString();
		JsonPath js = new JsonPath(json);
		String a =  js.get("data.tokenData");
		//System.out.println(a);
		
		PostReq_POJO1 Data1 = new PostReq_POJO1();
		Data1.setEmpno("100999");
		Data1.setIsFromMobile("false");
		
		Response res1 = (Response)
				
				given()
					.header("Authorization", "Bearer " + a)
					.body(Data1)
				.when()
					.post("http://103.138.234.244:9067/api/RoleMenu/RoleWiseMenuBinding");
		
		//System.out.println(res1.getBody().asPrettyString());
		
		File file = new File("responce.txt");
		FileWriter write = new FileWriter(file);
		write.write(res1.getBody().asPrettyString());			
		write.close();
		
		String b = res1.getBody().asPrettyString();
		JsonPath js1 = new JsonPath(b);
		String a1 =  js1.get("data.componentName");
		
		System.out.println(a1);

	}

}
