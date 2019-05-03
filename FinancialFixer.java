import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class FinancialFixer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		JOptionPane.showMessageDialog(null, "With a proper payment plan in place...");
//		int duration;
//		for (duration = 0; duration <= 20; duration = duration + 5) {
//			JOptionPane.showMessageDialog(null, duration + "...");
//			JOptionPane.showMessageDialog(null, "25+ years of living in your home is possible!");
//		}
		
		
		JOptionPane.showMessageDialog(null, "Welcome to Financial Fixer!");
		boolean continueRunningProgram = true;
		
		while (continueRunningProgram) {
			// Initialize loop
			try {
				
				String userChoice = JOptionPane.showInputDialog(
						"What would you like to do today? \n " + 
						"1. Calculate Monthly Mortage Payment \n " +
						"2. Calculate Maximum Mortage Payment \n "+ 
						"3. Calculate Remaining Loan Balance \n "+ 
						"4. Calculate Maximum Rent Payment \n (Enter the number)");
				
				System.out.println(userChoice);
				
				if (userChoice == null) {
					// if the user hits cancel then exit the program
					break;  
				}
				
				// if the user leaves the field blank, let them know
				if (userChoice.isEmpty()) {
					throw new Exception("Invalid input! Missing user input!");
				}
				
				int userChoiceInt;
				
				try {
					userChoiceInt = Integer.parseInt(userChoice);
				} catch(Exception error) {
					throw new Exception("Invalid input! Please enter a number.");
				}
				
				
				if (userChoiceInt == 1) {
					JOptionPane.showMessageDialog(null,
							"To calculate your monthly mortgage payment, please enter the following information.");
					String principal = JOptionPane.showInputDialog("Enter loan principal");
					String interestRate = JOptionPane.showInputDialog("Enter loan interest rate");
					String loanLength = JOptionPane.showInputDialog("Enter length of loan in years");

					double principalInt = Double.parseDouble(principal);
					double interestRateInt = Double.parseDouble(interestRate);
					interestRateInt = interestRateInt / 12;
					// monthly interest rate
					double loanLengthInt = Double.parseDouble(loanLength);
					loanLengthInt = loanLengthInt * 12;
					// years to months

					double payment = principalInt * ((interestRateInt * Math.pow(1 + interestRateInt, loanLengthInt))
							/ (Math.pow(1 + interestRateInt, loanLengthInt) - 1));
					payment = payment / 12;
					// equation

					DecimalFormat formatter = new DecimalFormat("#,###.00");
					JOptionPane.showMessageDialog(null, "Your monthly mortgage payment is: " + formatter.format(payment));

				} else if (userChoiceInt == 2) {
					
					JOptionPane.showMessageDialog(null,
							"To calculate your maximum mortgage payment, please enter the following information.");
					String income = JOptionPane.showInputDialog("Enter your gross annual income");

					double incomeInt = Double.parseDouble(income);
					double payment = (incomeInt * 0.28) / 12;

					DecimalFormat formatter = new DecimalFormat("#,###.00");
					JOptionPane.showMessageDialog(null,
							"Your maximum monthly mortgage payment should be " + formatter.format(payment));
					
				} else if (userChoiceInt == 3) {
					JOptionPane.showMessageDialog(null,
							"To calculate your remaining loan balance, please enter the following information.");
					String principal = JOptionPane.showInputDialog("Enter your loan principal");
					String interestRate = JOptionPane.showInputDialog("Enter your loan intrest rate");
					String monthlyPayment = JOptionPane.showInputDialog("Enter you monthly mortgage payment");
					String paymentsMade = JOptionPane.showInputDialog("Enter the amount of payments you have made");

					double principalInt = Double.parseDouble(principal);
					double interestRateInt = Double.parseDouble(interestRate);
					interestRateInt = (interestRateInt / 12) / 100;
					// monthly interest rate
					double monthlyPaymentInt = Double.parseDouble(monthlyPayment);
					double paymentsMadeInt = Double.parseDouble(paymentsMade);

					double balance = (principalInt * (Math.pow(1 + interestRateInt, paymentsMadeInt))) - monthlyPaymentInt
							* ((Math.pow(1 + interestRateInt, paymentsMadeInt) - 1) / (interestRateInt));

					DecimalFormat formatter = new DecimalFormat("#,###.00");
					JOptionPane.showMessageDialog(null, "Your remaining loan balance is: " + formatter.format(balance));
					
				} else if (userChoiceInt == 4) {
					JOptionPane.showMessageDialog(null,
							"To calculate your maximum rent payment, please enter the following information.");
					String income = JOptionPane.showInputDialog("Enter your gross annual income");
					int incomeInt = Integer.parseInt(income);
					int maxRent = incomeInt / 40;

					DecimalFormat formatter = new DecimalFormat("#,###.00");
					JOptionPane.showMessageDialog(null,
							"Your maximum monthly rent payment should be " + formatter.format(maxRent));
				} else {	
					throw new Exception("Invalid input! Please enter a number between 1 and 4.");
				}
								
				continueRunningProgram = promptUserToContinue();
				
				// user can continue to pick more options
				
			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, error.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, "Thank you for using FinancialFixer!");	
		System.exit(0);
	}
	
	
	public static boolean promptUserToContinue() throws Exception {
		int shouldContinue;
		shouldContinue = JOptionPane
				.showConfirmDialog(null, 
						"Would you like to complete another task?", 
						"Financial Fixer", 
						JOptionPane.YES_NO_OPTION);
		System.out.println(shouldContinue);
		
		if (shouldContinue == 0) { 
			return true;
		} else {
			return false;
		}
	}

}
