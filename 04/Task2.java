// Задание 2: Диапазон чисел

import java.util.Scanner;

public class Task2 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Please, enter second number: ");
        int secondNumber = scanner.nextInt();

        if (firstNumber < secondNumber) {
        	
			while (firstNumber <= secondNumber) {
				System.out.println(firstNumber);
				firstNumber++;
			}
        }		
	}
}