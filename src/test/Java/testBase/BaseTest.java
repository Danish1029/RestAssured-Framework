package testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import config.ConfigReader;
import io.restassured.RestAssured;

public class BaseTest {

    protected Logger logger;

    @BeforeSuite
    public void beforeSuite() {

        RestAssured.baseURI = ConfigReader.getProperty("base.url");

        System.out.println("========================================");
//        System.out.println("Environment : " + ConfigReader.getProperty("env"));
        System.out.println("Environment : QA");
 // System.out.println("Environment : " + ConfigReader.getEnvironment());
        System.out.println("Base URL    : " + RestAssured.baseURI);
        System.out.println("========================================");

    }

    @BeforeMethod
    public void setup() {

        logger = LogManager.getLogger(this.getClass());

        logger.info("========== Test Started ==========");

    }

    @AfterMethod
    public void tearDown() {

        logger.info("========== Test Finished ==========");

    }

}