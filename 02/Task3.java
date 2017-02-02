// Задание 3: Наибольшее из трёх чисел

public class Task3 {
	public static void main (String[] args) {

		System.out.print("Please enter first number: ");
		String firstUserNumber = System.console().readLine();

		System.out.print("Please enter second number: ");
		String secondUserNumber = System.console().readLine();

		System.out.print("Please enter third number: ");
		String thirdUserNumber = System.console().readLine();

		int a = Integer.parseInt(firstUserNumber);
		int b = Integer.parseInt(secondUserNumber);
		int c = Integer.parseInt(thirdUserNumber);

		if (a == b && b == c) {
			System.out.println("A == B == C");
		} else if (a > b && a > c) {
			System.out.println("Bigger number is: " + a);
		} else if (b > a && b > c) {
			System.out.println("Bigger number is: " + b);
		} else {
			System.out.println("Bigger number is: " + c);
		}
	}
}