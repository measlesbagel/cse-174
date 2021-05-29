/*
Name: Myles Cagle
Date: 9/22/2019
Section: C
Description: Randomly generates an integer 
and finds out if its even or odd
*/


public class IntGenerator {
  
  public static void main(String[] args) {
    //Initialize variables for program
    int randInt = 50 + (int) (Math.random()*51);
    String decision;

    //Conditional to calculate if the randomly generated number is even or odd
    decision = (randInt%2 == 0) ? "Even" : "Odd";

    //Output the number and if it was even or odd
    System.out.printf("The generated number is %d and it is %S!",randInt,decision);
  }
}
