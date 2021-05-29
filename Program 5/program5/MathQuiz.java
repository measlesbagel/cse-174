/*
Name: Myles Cagle
Date: 9/28/2019
Section: C
Description: Creates a math quiz involving 4
multiplicationand 4 division problems with 
a choie of difficulty, then calculates your 
score and tracks how long the quiz took
*/

import java.util.Scanner; 
import java.time.Instant;
import java.time.Duration;

public class MathQuiz {
  public static void main(String[] args) {
    //Initialize variables for program
    int x,y,answer,solution,score = 0,multiplier,mScore,dScore;
    long time;
    Instant start, stop;
    String difficulty;
    Scanner keys = new Scanner(System.in);

    //Output introduction statement about quiz
    System.out.println("Welcome to my math quiz!");
    System.out.println("This quiz will give you four multiplication problems,");
    System.out.println("followed by four division problems.");
    System.out.println("An easy quiz will include numbers up to 100.");
    System.out.println("A hard quiz will include numbers up to 1000.");
    System.out.println("-----------------------------------------------------");
    System.out.println("Do you want an easy quiz or a hard quiz?");

    //Choose difficulty
    System.out.print("Enter the word hard or easy:");
    difficulty = keys.next();

    System.out.println("\n-MULTIPLICATION--------------------------------------");
    System.out.printf("You have chosen %s",difficulty);

    //Set multiplier for numbers based off difficulty
    multiplier = (difficulty.equalsIgnoreCase("easy")) ? 10 : 31;

    //Starts tracking time
    start = Instant.now();
    
    //Loop for 4 multiplication questions
    for(int i = 0; i < 4; i++) {
      //Declares random numbers for division problems
      x = (int)(1 + Math.random()*multiplier);
      y = (int)(1 + Math.random()*multiplier);
      solution = x*y;
      System.out.printf("%n%d x %d = ",x,y);
      answer = keys.nextInt();
      
      //Checks users answer based on solution, calculates score
      if(answer == solution) {
        score++;
        System.out.printf("%nCorrect! %d answers correct so far",score);
      } else {
        System.out.printf("%nSorry, %d x %d = %d. %d answers correct so far",x,y,solution,score);
      }
    }
    mScore = score;

    System.out.println("\n\n-DIVISION--------------------------------------------");
    
    //Loop for 4 division questions
    for(int i = 0; i < 4; i++) {
      //Declares random numbers for division problems
      x = (int)(1 + Math.random()*multiplier);
      y = (int)(1 + Math.random()*multiplier);
      solution = (x*y)/x;
      System.out.printf("%n%d / %d = ",x*y,x);
      answer = keys.nextInt();
      
      //Checks users answer based on solution, calculates score
      if(answer == solution) {
        score++;
        System.out.printf("%nCorrect! %d answers correct so far",score);
      } else {
        System.out.printf("%nSorry, %d / %d = %d. %d answers correct so far.",x*y,x,solution,score);
      }
    }
    
    //Finds end time;
    stop = Instant.now();
    dScore = score - mScore;
    
    //Calculates total time answering questions
    time = Duration.between(start, stop).toMillis() / 1000;
    
    //Outputs results and statistics of math quiz
    System.out.print("\n\n-RESULTS---------------------------------------------");
    System.out.printf("%nYou answered the questions in %d seconds.",time);
    System.out.printf("%nMultiplication score: %d out of 4 (%.2f%%)",mScore,(mScore/4.0)*100);
    System.out.printf("%nDivision score: %d out of 4 (%.2f%%)",dScore,(dScore/4.0)*100);
    System.out.printf("%nOverall score: %d out of 8 (%.2f%%)",score,(score/8.0)*100);

  }
}
