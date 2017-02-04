// Задание 3: Загадайка загадывает

import java.util.Random;
import java.util.Scanner;

public class Task3 {
	public static void main (String[] args) {
		Random randomGenerator = new Random();
	    int randomNum = randomGenerator.nextInt(101);
	    
	    Scanner scanner = new Scanner(System.in);

	    boolean isMatch = true;

	    while (isMatch) {
		    System.out.print("Please, enter number: ");
	        int userNumber = scanner.nextInt();

	        if (userNumber < randomNum) {
	        	System.out.println("Your number is smaller then app number");
	        } else if (userNumber > randomNum) {
	        	System.out.println("Your number is larger then app number");
	        } else if (userNumber == randomNum) {
	        	System.out.println("Your number equals app number!");
	        	isMatch = false;
	        }
	    }
	}
}