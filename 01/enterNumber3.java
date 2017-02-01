public class enterNumber3 {
	public static void main (String[] args) {
		System.out.print("Please enter your number: ");
	    String userNumber = System.console().readLine();
	    int number = Integer.parseInt(userNumber);
	    System.out.println("Answer: " + number * number);
	}
}