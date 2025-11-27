import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.registrationandlogin.RegistrationAndLogin;

public class RegistrationAndLoginTest {

    // Test validateUsername
    @Test
    void testValidUsername() {
        assertTrue(RegistrationAndLogin.validateUsername("Keenan123"));
        assertFalse(RegistrationAndLogin.validateUsername("ST104"));
        assertFalse(RegistrationAndLogin.validateUsername("test user"));
    }

    // Test validatePassword
    @Test
    void testValidPassword() {
        assertTrue(RegistrationAndLogin.validatePassword("Test123@"));
        assertFalse(RegistrationAndLogin.validatePassword("test")); // too short
        assertFalse(RegistrationAndLogin.validatePassword("lowercase123@")); // no uppercase
        assertFalse(RegistrationAndLogin.validatePassword("UPPERCASE123")); // no special char
        assertFalse(RegistrationAndLogin.validatePassword("Uppercase@")); // no digit
    }

    // Test validateInternationalCellNumber
    @Test
    void testValidPhoneNumber() {
        assertTrue(RegistrationAndLogin.validateInternationalCellNumber("+27831234567"));
        assertFalse(RegistrationAndLogin.validateInternationalCellNumber("0831234567"));
        assertFalse(RegistrationAndLogin.validateInternationalCellNumber("+abc1234567"));
    }

    // Test User object creation
    @Test
    void testUserCreation() {
        RegistrationAndLogin.User user = new RegistrationAndLogin.User(
                "Keenan123", "Test123@", "+27831234567", "Keenan", "Scully");

        assertEquals("Keenan123", user.getUsername());
        assertEquals("Test123@", user.getPassword());
        assertEquals("+27831234567", user.getPhoneNumber());
        assertEquals("Keenan", user.getFirstName());
        assertEquals("Scully", user.getLastName());
    }

    // Test Message ID length
    @Test
    void testMessageIDLength() {
        RegistrationAndLogin.Message message = new RegistrationAndLogin.Message(1, "+27831234567", "Hello World");
        assertEquals(10, message.getId().length());
    }

    // Test Message Hash generation
    @Test
    void testMessageHash() {
        RegistrationAndLogin.Message message = new RegistrationAndLogin.Message(1, "+27831234567", "Hello World");
        String hash = message.getHash();
        assertTrue(hash.startsWith(message.getId().substring(0, 2) + ":1:HELLOWORLD"));
    }

    // Test addMessage functionality
    @Test
    void testAddMessageToUser() {
        RegistrationAndLogin.User user = new RegistrationAndLogin.User(
                "Keenan123", "Test123@", "+27831234567", "Keenan", "Scully");

        user.addMessage("This is my first message");
        user.addMessage("Another message");

        assertEquals(2, user.getMessages().size());
        assertTrue(user.getMessages().contains("This is my first message"));
    }
}
