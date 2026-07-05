package utils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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
                .body(matchesJsonSchemaInClasspath("schemas/" + schemaFile));

        logger.info("JSON Schema Validation Passed : {}", schemaFile);
    }
}