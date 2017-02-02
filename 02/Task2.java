// Задание 2: Наибольшее из двух чисел

public class Task2 {
	public static void main (String[] args) {

		System.out.print("Please enter first number: ");
		String firstUserNumber = System.console().readLine();

		System.out.print("Please enter second number: ");
		String secondUserNumber = System.console().readLine();

		int firstNumber = Integer.parseInt(firstUserNumber);
		int secondNumber = Integer.parseInt(secondUserNumber);

		if (firstNumber != secondNumber) {
			System.out.println("Bigger number is: " + Math.max(firstNumber, secondNumber));
		} else {
			System.out.println("A == B");
		}	
	}
}