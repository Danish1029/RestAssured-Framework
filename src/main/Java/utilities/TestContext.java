package utilities;

public final class TestContext {

    private TestContext() {
    }

    private static long petId;

    public static long getPetId() {
        return petId;
    }

    public static void setPetId(long petId) {
        TestContext.petId = petId;
    }

}