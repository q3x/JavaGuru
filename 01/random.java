import java.util.Random; 

public class random {
	public static void main (String[] args) {
		Random randomGenerator = new Random();
	    int num1 = randomGenerator.nextInt(100);
	    int num2 = randomGenerator.nextInt(100);
	    int num3 = randomGenerator.nextInt(100);

	    System.out.println("First random number is: " + num1);
	    System.out.println("Second random number is: " + num2);
	    System.out.println("Third random number is: " + num3);

		System.out.println("Sum of random numbers is: " + (num1 + num2 + num3));
	}
}