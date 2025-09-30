package service;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import util.EmailUtil;

import java.util.List;

import static org.mockito.Mockito.*;

class AlertServiceTest {

	@Test
	void testCheckMinimumBalanceAndNotify() {
		
		try (MockedStatic<EmailUtil> mockedEmailUtil = mockStatic(EmailUtil.class)) {

			// Arrange: Set up the test data and mock how it behaves
			Customer customer = new Customer(1L, "John Doe", "johndoe@example.com");
			Account account = new Account(1L, "1234", 50.0, 100.0, 50.0);

			// Create AlertService instance
			AlertService alertService = new AlertService(List.of(customer), List.of(account), List.of());

			// Act: Call the method being tested
			alertService.checkMinimumBalanceAndNotify();

			// Assert: Verify the results/ Verify that EmailUtil.sendEmail was called with
			// the correct arguments
			mockedEmailUtil.verify(() -> EmailUtil.sendEmail(eq("johndoe@example.com"), eq("Minimum Balance Alert"),
					contains("your account balance is below the minimum")), times(1));
		}
	}
}