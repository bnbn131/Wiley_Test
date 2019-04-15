import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import io.restassured.response.Response;




// К сожалению опыта в тестировании API нет, с помощью Habra и библиотеки RestAssured получилось вот это решение.
public class RestTest {

    public String baseUrl = "https://httpbin.org";


    @Test
    public void testDelay () {

        Response response = get(baseUrl + "/delay/1");
               Assert.assertEquals(response.statusCode(), 200);
                Assert.assertFalse(response == null);
//                response.getBody().print();



    }


    @Test
    public void testPng () {

        Response response = get(baseUrl + "/image/png");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.getHeader("Content-Type").equals("image/png"));



    }
}
