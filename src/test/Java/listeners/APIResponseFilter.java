package listeners;

import java.io.PrintStream;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class APIResponseFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        Response response = ctx.next(requestSpec, responseSpec);

        PrintStream stream = System.out;

        stream.println("\n============== API RESPONSE ==============");

        stream.println("Status Code  : " + response.getStatusCode());
        stream.println("Status Line  : " + response.getStatusLine());
        stream.println("Response Time: " + response.getTime() + " ms");

        stream.println("\nHeaders:");
        stream.println(response.getHeaders());

        stream.println("\nResponse Body:");
        stream.println(response.asPrettyString());

        stream.println("==========================================\n");

        return response;
    }

}