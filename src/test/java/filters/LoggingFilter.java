package filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
    private static final Logger Logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                         FilterableResponseSpecification responseSpec,
                         FilterContext ctx) {
// Log request
        logRequest(requestSpec);

Response response = ctx.next(requestSpec, responseSpec);

// Log response
        logResponse(response);

        return response;
    }

    private void logRequest(FilterableRequestSpecification requestSpec) {
        Logger.info("BASE URI:"+ requestSpec.getBaseUri());
        Logger.info("BASE Header:"+ requestSpec.getHeaders());
    	//logger.info("Request: {} {}", requestSpec.getMethod(), requestSpec.getURI());
        //logger.info("Headers: {}", requestSpec.getHeaders());
    }

    private void logResponse(Response response) 
    {
    	Logger.info("STATUS CODE:"+ response.getStatusCode());
    	
        //logger.info("Response Status: {}", response.getStatusCode());
        //logger.info("Response Body: {}", response.getBody().asString());
    }
}

