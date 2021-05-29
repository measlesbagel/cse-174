/*
Name: Myles Cagle
Instructor: Manar
CSE 174 Section C
Date: 08/28/2019
Filename Firstprogram.java
Description: Practice with writing, saving and compiling code
*/
import java.util.Scanner; // We need this for user input
/*
Demonstrates some basic programming concepts by getting information
from the keyboard, displaying results to the screen and playing an
interactive game with the users
*/
public class FirstProgram{
  /*
  The starting point for the program. This method
  calls on the other three methods as needed
  */
  public static void main(String[] arg) {
    // declaring local variables for later use
    String firstName, lastName;
    int targetNumber, userGuess, countGuesses;
    int triangleHeight;
    Scanner keyboardReader = new Scanner(System.in);

    // get user's name
    System.out.println("Enter first and last name");
    firstName = keyboardReader.next();
    lastName = keyboardReader.next();

    // display a marquee with a personal greeting
    printBorder('*', 30);
    greet(firstName + " " + lastName);
    printBorder('*', 30);

    // Explain how to play the game
    explainGame(firstName);

    //set up the game
    targetNumber = (int) (1 + 100 * Math.random());
    for(countGuesses = 1; countGuesses <=10; countGuesses++) {
      printBorder('*', 30);
      System.out.print("Enter guess #" + countGuesses + ":");
      userGuess = keyboardReader.nextInt();

      // the user made the right guess
      if(userGuess == targetNumber) {
        System.out.print("Good job " + firstName + ", ");
        System.out.println("You got it in " + countGuesses + " tries.");
        break;
      }
    // give advice - let user know if his guess is higher or lower than the target number
      else if (userGuess < targetNumber)  {
        System.out.println("Too low. Guess higher.");
      }
      else {
        System.out.println("Too high. Guess lower.");
      }
    }
    // the user could not guess the number in 10 trials
    if(countGuesses > 10)  {
      System.out.println("Hard luck! " + firstName + " ");
    }
    // some artwork:
    printBorder('#', 30);
    System.out.println("And now, a triangle of @!");
    triangleHeight = (int)(1 + 30 * Math.random());
    // display a triangle
    for (int row = 1; row <= triangleHeight; row++) {
      printBorder((char)64, row);
    }
  }// end main method

  //prints a personalized welcome message.
  public static void greet(String name) {
    System.out.println("Hello " + name + ", ");
    System.out.println("Welcome to my first CSE 174 program!");
    System.out.println("Enjoy the show!");
    System.out.println(" Sincerely, \n Myles Cagle");
  }//end greet method

  //prints a personalized game introduction
  public static void explainGame(String name) {
    System.out.println("Let play a game, " + name + "...");
    System.out.println("I'm thinking of a number from 1 to 100.");
    System.out.println("See if you can guess it in fewer than 10 tries.");
  }//end explainGame method

  //prints a border by repeating the specified symbol
  public static void printBorder(char symbol, int size) {
    for (int i = 0; i < size; i++)  {
      System.out.print(symbol);
    }
    System.out.println(); //moves to the next line
  }//end printBorder method
}//end class
