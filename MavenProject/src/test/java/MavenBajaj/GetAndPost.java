package MavenBajaj;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
@Test
public class GetAndPost {
	public void Get()
	{
		 baseURI ="https://reqres.in/api";
		 
		 given().
		 get("/users?page=2").
		 then().
		 statusCode(200).
		 body("data[0].id",equalTo(7)).
		 body("data[0].first_name",equalTo("Michael")).
		 body("data.first_name",hasItems("Michael","Lindsay","George"));
		 
	}
	@Test
	public void Post()
	{
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("name","Kshitiz");
		map.put("job", "Engineer");
		
		JSONObject request = new JSONObject();
		
		request.put("name","Kshitiz");
		request.put("job", "Engineer");
	
		System.out.println(request.toJSONString());
		
		baseURI ="https://reqres.in/api";
		
		given().
		header("content-type","application/json").
		body(request.toJSONString()).
		when()
		.post("/users")
		.then()
		.statusCode(201).log().all();
	}
	
}