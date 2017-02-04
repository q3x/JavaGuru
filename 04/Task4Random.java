// Задание 4: Угадайка отгадывает (Вариант РАНДОМ)

import java.util.Random;

public class Task4Random {
	public static void main (String[] args) {
		Random randomGenerator = new Random();
		System.out.println("--------------------------" + "\n" + "Chose some number in mind!" + "\n" + "--------------------------");
	    boolean isMatch = false;

	    while(isMatch == false) {
	    	int randomNum = randomGenerator.nextInt(101);
	    	
	    	System.out.println("Is your number equals: " + randomNum + "?");
	    	System.out.println("Please write Yes/Larger/Smaller :");
	    	String userAnswer = System.console().readLine();

	    	if (userAnswer.equals("Yes")) {
	    		isMatch = true;
	    	} 
	    }	    
	}
}