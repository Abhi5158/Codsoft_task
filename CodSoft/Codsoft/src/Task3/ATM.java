package Task3;

import java.util.Scanner;

public class ATM {
	private BankAccount account;

	public ATM(BankAccount account) {
		this.account = account;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		System.out.println("\n===== Welcome to the ATM =====");

		while (running) {
			System.out.println("\nChoose an option:");
			System.out.println("1️⃣ Withdraw");
			System.out.println("2️⃣ Deposit");
			System.out.println("3️⃣ Check Balance");
			System.out.println("4️⃣ Exit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: // Withdraw
				System.out.print("Enter amount to withdraw: ₹");
				double withdrawAmount = scanner.nextDouble();
				account.withdraw(withdrawAmount);
				break;

			case 2: // Deposit
				System.out.print("Enter amount to deposit: ₹");
				double depositAmount = scanner.nextDouble();
				account.deposit(depositAmount);
				break;

			case 3: // Check Balance
				System.out.println("💰 Your current balance is: ₹" + account.checkBalance());
				break;

			case 4: // Exit
				System.out.println("🚪 Thank you for using the ATM. Have a great day!");
				running = false;
				break;

			default:
				System.out.println("❌ Invalid choice! Please select a valid option.");
			}
		}
		scanner.close();
	}
}
