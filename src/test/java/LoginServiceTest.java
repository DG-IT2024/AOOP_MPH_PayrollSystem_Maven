import org.junit.jupiter.api.*;
import service.LoginService;
import util.DBConnect;

import java.sql.Connection;

public class LoginServiceTest {

    private static Connection conn;
    private LoginService loginService;
    private final String username = "manuel_garcia";
    private final String correctPassword = "fafk21@";
    private final String wrongPassword = "wrong123";

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
    }

    @BeforeEach
    public void initService() throws Exception {
        loginService = new LoginService();
        // Reset before each test to ensure a clean start
        loginService.resetLoginAttempts(username);
    }

    @AfterEach
    public void resetLoginAttemptsAfterTest() throws Exception {
        // Reset after each test to clean up in case a test fails
        loginService.resetLoginAttempts(username);
    }

    @Test
    public void testCase1_CorrectCredentials() throws Exception {
        boolean result = loginService.authenticate(username, correctPassword);
        System.out.println("Test Case 1 - Correct username and password: " + result);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCase2_OneFailedAttemptThenSuccess() throws Exception {
        boolean fail1 = loginService.authenticate(username, wrongPassword);
        System.out.println("Test Case 2.1 - Failed attempt: " + fail1);
        Assertions.assertFalse(fail1);

        boolean success = loginService.authenticate(username, correctPassword);
        System.out.println("Test Case 2.2 - Successful login after one failure: " + success);
        Assertions.assertTrue(success);
    }

    @Test
    public void testCase3_ThreeFailedThenBlocked() throws Exception {
        // Do 3 failed attempts
        for (int i = 1; i <= 3; i++) {
            boolean fail = loginService.authenticate(username, wrongPassword);
            System.out.println("Test Case 3." + i + " - Failed attempt: " + fail);
        }

        // Try correct credentials after blocking
        boolean result = loginService.authenticate(username, correctPassword);
        System.out.println("Test Case 3.4 - Try correct credentials after 3 failed attempts: " + result);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCase4_WrongUsernameCorrectPassword() throws Exception {
        boolean result = loginService.authenticate("wrong_user", correctPassword);
        System.out.println("Test Case 4 - Incorrect username, correct password: " + result);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCase5_WrongUsernameAndPassword() throws Exception {
        boolean result = loginService.authenticate("fake_user", "badpass");
        System.out.println("Test Case 5 - Incorrect username and password: " + result);
        Assertions.assertFalse(result);
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}


//
//import org.junit.jupiter.api.*;
//import service.LoginService;
//import model.Login;
//import model.Password;
//import dao.LoginDAO;
//
//
//
//import java.sql.Connection;
//
//import util.DBConnect;
//
//public class LoginServiceTest {
//
//    private LoginService loginService;
//    private LoginDAO loginDAOMock;
//    private Login testLogin;
//    private Password testPassword;
//    private static Connection conn;
//
//    @BeforeAll
//    public static void setup() throws Exception {
//        conn = DBConnect.getConnection(); // Uses URL, user, and password from DBConnect
//    }
//
//    
//    
//     @AfterAll
//     public static void teardown() throws Exception{
//         
//         if (conn!=null &&!conn.isClosed()){
//             conn.close();
//         }
//             
//     }
//     
//
//}
//
