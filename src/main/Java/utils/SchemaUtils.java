package utils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;

public final class SchemaUtils {

    private static final Logger logger = LogManager.getLogger(SchemaUtils.class);

    private SchemaUtils() {
    }

    public static void validateSchema(Response response, String schemaFile) {

        response.then()
                .assertThat()
                .body(
                	    io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(
                	        SchemaUtils.class.getClassLoader()
                	                .getResourceAsStream("schemas/" + schemaFile)
                	    )
                	);
                
                
     /*           .body(matchesJsonSchemaInClasspath("schemas/" + schemaFile));
*/
                
// =================================================        
        
        String schemaPath = null;
		// Debug classpath
        URL resource = SchemaUtils.class
                .getClassLoader()
                .getResource(schemaPath);

        System.out.println("Schema Path : " + schemaPath);
        System.out.println("Schema URL  : " + resource);

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(schemaPath));  

// ========================================================================        
        
        logger.info("JSON Schema Validation Passed : {}", schemaFile);
    }
}