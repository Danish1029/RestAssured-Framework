package testCases;

import config.ConfigReader;

public class ConfigTest {

    public static void main(String[] args) {

        System.out.println(ConfigReader.getEnvironment());

        System.out.println(ConfigReader.getBaseURL());

        System.out.println(ConfigReader.getConnectTimeout());

        System.out.println(ConfigReader.getReadTimeout());

    }

}