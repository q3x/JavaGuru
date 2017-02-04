// Задание 4: Угадайка отгадывает - вариант АЛГОРИТМ

import java.util.Random;

public class Task4Algorithm {
	public static void main (String[] args) {
		Random randomGenerator = new Random();
		System.out.println("--------------------------" + "\n" + "Chose some number in mind!" + "\n" + "--------------------------");
	    boolean isMatch = false;
	    int randomNum = randomGenerator.nextInt(101);

	    // Задаём "крайние" числа
	    int leftNum = 0;
	    int rightNum = 100;

	    while(isMatch == false) {
	    		    	
	    	System.out.println("Is your number equals: " + randomNum + "?");
	    	System.out.println("Please write Yes/Larger/Smaller :");
	    	String userAnswer = System.console().readLine();

	    	if (userAnswer.equals("Yes")) {
	    		isMatch = true;
	    	} else if (userAnswer.equals("Larger")) {
	    		leftNum = randomNum;
	    		randomNum = randomNum + ((rightNum - randomNum) / 2);
	    	} else if (userAnswer.equals("Smaller")) {
	    		rightNum = randomNum;
	    		randomNum = randomNum - ((randomNum - leftNum) / 2);
	    	}
	    }	    
	}
}