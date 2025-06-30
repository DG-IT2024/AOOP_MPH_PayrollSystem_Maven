import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SanityTest {

    @BeforeAll
    public static void setUp() {
        System.out.println("🚀 Starting Sanity Tests...");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("🧹 Finished Sanity Tests.");
    }

    @Test
    public void testBasicMath() {
        int result = 1 + 1;
        System.out.println("Sanity check result: " + result);
        assertEquals(2, result, "1 + 1 should equal 2");
    }
}
