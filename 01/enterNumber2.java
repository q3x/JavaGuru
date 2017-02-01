public class enterNumber2 {
	public static void main (String[] args) {
		System.out.print("Please enter first number: ");
	    String userFirstNumber = System.console().readLine();

	    System.out.print("Please enter second number: ");
	    String userSecondNumber = System.console().readLine();

	    int sumOfNumbers = Integer.parseInt(userFirstNumber) + Integer.parseInt(userSecondNumber);

	    System.out.println("Sum of your numbers is: " + sumOfNumbers);
	}
}