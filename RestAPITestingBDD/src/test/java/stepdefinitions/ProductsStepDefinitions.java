package stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.net.http.HttpRequest;

import org.json.simple.JSONObject;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ProductsStepDefinitions {

	public int statusCode;
	public RequestSpecification httpRequest;
	public Response response;
	public int respCode;
	public ResponseBody body;
	public JSONObject requestParams;

	@Given("I hit the url of get products api endpoint")
	public void i_hit_the_url_of_get_products_api_endpoint() {
		RestAssured.baseURI = "https://fakestoreapi.com/";

	}

	@When("I pass the url of products in the request")
	public void i_pass_the_url_of_products_in_the_request() {
		httpRequest = RestAssured.given();
		response = httpRequest.get("products");
	}

	@When("I recieve the response code as {int}")
	public void i_recieve_the_response_code_as(Integer int1) {
		respCode = response.getStatusCode();
		assertEquals(respCode, int1.intValue());

	}

	@Then("I verify the rate of the first product is {double}")
	public void i_verify_the_rate_of_the_first_product_is(Double double1) {
		body = response.getBody();
		// String responseBody=body.asString();
		// System.out.println(responseBody);

		JsonPath jsonPath = response.jsonPath();
		String s = jsonPath.getJsonObject("rating").toString();
		String s1 = jsonPath.getJsonObject("rating[0].rate").toString();

		System.out.println(s);
		System.out.println(s1);
		assertEquals(s1, double1.toString());

	}

	@Given("I hit the url of post products api endpoint")
	public void i_hit_the_url_of_post_products_api_endpoint() {
		// Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = "https://fakestoreapi.com/";
		httpRequest = RestAssured.given();

		// response = httpRequest.post("products");

	}

	@When("I pass the request body of product title {string}")
	public void i_pass_the_request_body_of_product_title(String string) {
		// Write code here that turns the phrase above into concrete actions

		requestParams = new JSONObject();
		requestParams.put("title", string);
		requestParams.put("price", 9.99);
		requestParams.put("description", "Nike");
		requestParams.put("image", "http://example.com/shoe");
		requestParams.put("category", "Jordon");
		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.post("products");
		ResponseBody body = response.getBody();
		System.out.println(response.getStatusLine());
		System.out.println(body.asString());
	}

}
