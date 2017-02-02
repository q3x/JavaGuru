// Задание 1: Больше, меньше, равно

public class Task1 {
	public static void main (String[] args) {

		System.out.print("Please enter number: ");
	    String userNumber = System.console().readLine();
	    int number = Integer.parseInt(userNumber);

	    if (number < 0) {
	    	System.out.println("Your number is negative.");
	    } else if (number == 0) {
	    	System.out.println("Your number is: 0");
	    } else {
	    	System.out.println("Your number is positive");
	    }
	}
}