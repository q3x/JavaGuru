// Задание 3: Чётные числа

import java.util.Scanner;

public class Task3 {
	public static void main (String[] args) {

	    Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Please, enter second number: ");
        int secondNumber = scanner.nextInt();

        if (firstNumber < secondNumber) {
        	for (int i= firstNumber; i <= secondNumber; i++) {
                    if ((i % 2) == 0) {
                    	System.out.println(i);
                    }
                    
                }
        }
    }
}