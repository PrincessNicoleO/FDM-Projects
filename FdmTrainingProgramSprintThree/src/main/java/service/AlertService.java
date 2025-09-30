package service;

import java.util.List;

import jakarta.mail.MessagingException;
import util.EmailUtil;

public class AlertService {
	private List<Customer> customers;
	private List<Account> accounts;
	private List<DepositBox> depositBoxes;

	public AlertService(List<Customer> customers, List<Account> accounts, List<DepositBox> depositBoxes) {
		this.customers = customers;
		this.accounts = accounts;
		this.depositBoxes = depositBoxes;
	}

	public void sendTransactionAlert(Long customerId) {
		customers.stream().filter(customer -> customer.getId().equals(customerId)).findFirst().ifPresent(customer -> {
			accounts.stream().filter(account -> account.getCustomerId().equals(customerId)).forEach(account -> {
				String message = generateAlertMessage(customer, account);
				try {
					EmailUtil.sendEmail(customer.getEmail(), "Transaction Alert", message);
				} catch (MessagingException e) {
					System.err.println("Failed to send alert email: " + e.getMessage());
				}
			});
		});
	}

	public void checkMinimumBalanceAndNotify() {
		accounts.stream().filter(Account::isBelowMinimumBalance).forEach(account -> {
			customers.stream().filter(customer -> customer.getId().equals(account.getCustomerId())).findFirst()
					.ifPresent(customer -> {
						String message = "Dear " + customer.getName()
								+ ", your account balance is below the minimum. A fine may apply.";
						try {
							EmailUtil.sendEmail(customer.getEmail(), "Minimum Balance Alert", message);
						} catch (MessagingException e) {
							System.err.println("Failed to send minimum balance alert: " + e.getMessage());
						}
					});
		});
	}

	public void notifyDepositBoxChanges(DepositBox depositBox, boolean isAllotted) {
		String message = isAllotted
				? "Dear " + depositBox.getCustomer().getName() + ", a deposit box has been allotted to you."
				: "Dear " + depositBox.getCustomer().getName() + ", your deposit box access has been revoked.";
		try {
			EmailUtil.sendEmail(depositBox.getCustomer().getEmail(), "Deposit Box Notification", message);
		} catch (MessagingException e) {
			System.err.println("Failed to send deposit box notification: " + e.getMessage());
		}
	}

	private String generateAlertMessage(Customer customer, Account account) {
		return "Hello " + customer.getName() + ",\n\n"
				+ "We would like to notify you of a recent transaction on your account.\n\n" + "Transaction Details:\n"
				+ "- Amount: $" + account.getLastTransactionAmount() + "\n" + "- Account Number: "
				+ account.getAccountNumber() + "\n" + "- New Balance: $" + account.getBalance() + "\n\n"
				+ "Thank you for banking with us.\n\n" + "Best regards,\n" + "Your Bank";
	}

	public List<DepositBox> getDepositBoxes() {
		return depositBoxes;
	}

	public void setDepositBoxes(List<DepositBox> depositBoxes) {
		this.depositBoxes = depositBoxes;
	}
}
