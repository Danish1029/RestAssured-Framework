package listeners;

import java.io.PrintStream;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class APIRequestFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        PrintStream stream = System.out;

        stream.println("\n================ API REQUEST ================");

        stream.println("Method      : " + requestSpec.getMethod());
        stream.println("URI         : " + requestSpec.getURI());
        stream.println("Headers     : " + requestSpec.getHeaders());

        if (requestSpec.getBody() != null) {
            stream.println("Body        : ");
            stream.println(String.valueOf(requestSpec.getBody()));
        }

        stream.println("=============================================\n");

        return ctx.next(requestSpec, responseSpec);
    }
}