package MavenBajaj;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutAndDelete {

	@Test
	public void Put()
	{
       JSONObject request = new JSONObject();
		
		request.put("name","Kshitiz");
		request.put("job", "Student");
	
		System.out.println(request.toJSONString());
		
		baseURI ="https://reqres.in/api";
		
		given().
		header("content-type","application/json").
		body(request.toJSONString()).
		when()
		.put("/users/2")
		.then()
		.statusCode(200).log().all();
	}
	
	@Test
	public void Delete()
	{
       baseURI ="https://reqres.in/api";
		
		when()
		.delete("/users/2")
		.then()
		.statusCode(204).log().all();
	}
}