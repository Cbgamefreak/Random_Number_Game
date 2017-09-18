/**

Name: Charles Butler 

Due Date: 03/5/2017

ITI 201-section 01 Introduction to Computer Concepts

Homework: Week 7 Individual assignment 4

Description: Write a program which picks a random number and asks the user for his entry. Prints too high if the entry is too high and too low if the entry is too low, repeating until the user get it correct. 
The program must also ask the user if they want to play again. The program must loop and terminate gracefully. ALso make sure the input is legitimate Extra credit if you allow the user to enter the maximum possible random number for the game
*/

import java.util.Random;
import java.util.Scanner; //import scanner and random java packages
public final class Random_Number_Game {
	static int maximum;// declare global variable of maximum to use in multiple methods.. YES i used a global variable - burn the witch
  public static final void main(String []Args){//main method

System.out.println("Hello, Welcome to the Random Number Game"); // print welcome message

play(); //runs the play method
  }
  
  static void play(){//this method asks the user whether he wants to play the game if its not his first time
	
	 int play = 1; // checks whether user is playing I know i could have used booleans here but it was making my code crash because of while loop errors iterating through booleans twice *** 1 == on and 0 == off ***
	 int playagain = 0;// also acts as a boolean to check whether user is done playing
	 

	 String playagain2 = new String(""); //string takes in user input to play again
	
	 while(play == 1){ //checks if the user is currently playing or not
		 gameOn();// if the user wants to play it runs this method
		playagain = 1; //turns playagain on
		play = 0;
		while(playagain == 1)//checks if the user has finished playing the game yet
		{
			 String no = new String("n");//strings to take in users input for yes or no
			 String yes = new String("y");
			 String no2 = new String("N");
			 String yes2 = new String("Y");
				
		System.out.println("Would you like to play again (y or n)?"); //asks the user if he wants to play again
	     Scanner keyboard = new Scanner (System.in); 
	    playagain2 = keyboard.nextLine();//takes in input
	     if((playagain2.equals(yes) || (playagain2.equals(yes2))))//checks if the user wants to play again, if so turn play on and playagain off (so it doesnt ask the user again)
	     {
	    	
	        play = 1;
	        playagain = 0;
	        System.out.println("Lets Play Again!");
		    
	     }
	     else if((playagain2.equals(no) || (playagain2.equals(no2))))/// if the user enters N for no it ends the program, turning both play and playagain off
	     {
	        play = 0;
	        playagain = 0;
	        System.out.println("Thank you for playing. Have a good day.");
	        break;
	       
	        
	     }
	     else {
	    	 System.out.println("That is not a valid entry");//if the user enters anything else but y or n it throws an error message
	    	 play = 0;
	    	 playagain = 1;
	     }
		}
		}
	 }

	 

	static void gameOn() // this is the method where the user actually plays the game
	 {
		int max = 0;//resets max to 0
		Scanner keyboard = new Scanner(System.in);
		boolean numberError = false;//number error boolean to check if user entered an integer or not
		  int a = 0;
	    int guess = 0;
	    String enteredString = " ";
	while (max == 0) //checks if max is 0
	{
	   do{ //do/while try/catch loop to catch false input
		   
		   try {   
	   System.out.println("Please enter a maximum random number for the game: "); //asks user for maximum number to play the game with
	   
	  max = keyboard.nextInt();
	   maximum = max; //takes in max input for number game and sets it equal to global maximum
	   numberError = false;//sets number error to false so program knows not to throw error and continue with method
	   if (max == 0){
			 System.out.println("That is not a valid number");//checks if max is still equal to 0 and throw an error. to prevent users from breaking code RIGHT USER???
		}
		   }
	   catch(Exception e){
			 System.out.println("That is not a valid number"); //if input is not an integer, this catches it and throws error
			 numberError = true;//sets number error to true so program reruns do/while loop
			 keyboard.nextLine();
		 }
		 } 
	   while (numberError == true);
	 }
	   int number = randomNumber(a);//sets the winning number equal to the random number from the random number method
	 
   do{//another do while loop to check if input is actually an integer
		   
		   try {  
		
	 while (guess != number && max > 0){//checks if user has guessed correctly and entered a max, if he hasnt guessed correctly it loops, if he has, this method ends and it goes back to the play method

		  
		 
		System.out.println("Enter a guess between 1-" + maximum); //asks to enter guess between 1 and max, takes in users next input
		  guess = keyboard.nextInt(); 
		  enteredString = keyboard.nextLine();
		  numberError = false;//sets number error to false so that it doesnt throw exception error
			   
			 
			   
		    
				 
	  if (guess > number && guess <= max && guess > 0){//if guess is more than winning number it prints that the number is too high
		  System.out.println("Your number is too high, please guess again");	 
	  }
	  else  if (guess < number && guess <= max && guess > 0){//if guess is less than winning number it prints that the number is too less
		  System.out.println("Your number is too low, please guess again");
	  }
	  else if (guess == number){//if the guess is equal to the winning number it says that the user is a winner and prints out 
		  System.out.println("You are correct, your number was: " + number);
	
	  }
	  else if (guess > max){//if the guess is more than the max it throws an invalid message
		  System.out.println("That is not a valid number");
	  }
	  else {//if the user entered anything other integer thats not between 1 and the max it throw an invalid message
		  System.out.println("That is not a valid number");
	  }
	 
	 }
		   }
	  catch(Exception e){//catches to see if user entered an actual integer, if not it throws an error message to user and prompts to enter again
			 System.out.println("That is not a valid number");
			 numberError = true;
			 keyboard.nextLine();
		 }
		 } while (numberError == true); 
	   }
	   

	 
	 
	
  
  
	 static int randomNumber(int x){ //this is the random number method
	 int max = 0;
	  int min = 1;
	  max = maximum;	//sets the max from the random number to the global maximum defined in the previous method (gameOn)
	  Random numb = new Random();//declares random number
	  int  n = numb.nextInt((max - min) + 1) + min; //sets random number to the difference between the max and min + 1 + the min so that you get numbers only between 1 and max (got idea from google)
	  
	  return n;//returns random number
	 
	  
	 
  }


}