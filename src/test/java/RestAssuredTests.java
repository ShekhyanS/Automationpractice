import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class RestAssuredTests {
    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void verifyStatusCode() {
        Response response = RestAssured.when().get("/users").andReturn();
        Assert.assertTrue(response.getStatusLine().contains("200 OK"));
    }

    @Test
    public void verifyContentType() {
        Response response = RestAssured.when().get("/users").andReturn();
        Headers headers = response.getHeaders();
        Assert.assertTrue(headers.hasHeaderWithName("Content-Type"));
        Assert.assertEquals(headers.getValue("Content-Type"), "application/json; charset=utf-8");
    }

    @Test
    public void verifyUsersQuantityInResponse() {
        Response response = RestAssured.when().get("/users").andReturn();
        JsonPath jsonpath = response.jsonPath();
        List<String> idList = jsonpath.get("id");
        Assert.assertEquals(idList.size(),10);
    }

}
