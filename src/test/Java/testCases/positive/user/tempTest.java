package testCases.positive.user;

import org.testng.annotations.Test;

public class tempTest {
	@Test
	public void verifyResourceLoading() {

	    ClassLoader loader = Thread.currentThread().getContextClassLoader();

	    System.out.println("--------------------------------");

	    System.out.println(loader.getResource("schemas/UserSchema.json"));

	    System.out.println(loader.getResource("testData/PetData.xlsx"));

	    System.out.println(loader.getResource("config.properties"));

	    System.out.println("--------------------------------");
	}
}
