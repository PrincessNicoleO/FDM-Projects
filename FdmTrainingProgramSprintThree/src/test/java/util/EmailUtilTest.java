package util;

import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailUtilTest {

    @Test
    public void testSendEmail_InvalidRecipient() {
        String invalidEmail = "invalid-email";
        String subject = "Test Subject";
        String body = "Test Body";

        // Expect MessagingException due to invalid email address
        assertThrows(MessagingException.class, () -> 
            EmailUtil.sendEmail(invalidEmail, subject, body)
        );
    }
}

