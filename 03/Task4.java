// Задание 4: Сумма чисел

import java.util.Scanner;

public class Task4 {
	public static void main (String[] args) {

	Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Please, enter second number: ");
        int secondNumber = scanner.nextInt();

        if (firstNumber < secondNumber) {

            int sum = 0;

        	for (int i = firstNumber; i <= secondNumber; i++) {
                   sum = sum + i;
                   System.out.println(i);
                   }
                System.out.println(sum);              
                }
        }       
}