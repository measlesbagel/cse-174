/*
Name: Myles Cagle
Date: 10/30/2019
Section: C
Description: Creates a program that can create
and change arrays doing thing such as finding
the alternating sum, reversing array order, or
analyzing runs in an array of 20 dice rolls.
*/

import java.util.Scanner;

public class Program10 {
  //Global scanner
  public static Scanner keys = new Scanner(System.in);

  //Creates menu for program choices
  public static void main(String[] args) {
    int choice = -1;

    //Loops menu until user wants to stop
    while(choice != 4) {
      System.out.println("PROGRAM#10");
      System.out.println("1 - alternatingSum");
      System.out.println("2 - Reverse");
      System.out.println("3 - Run");
      System.out.println("4 - Exit");
      System.out.print("Enter a number [1-4]: ");
      choice = keys.nextInt();

      switch(choice) {
        case 1: System.out.println("The result is: " + alternatingSum() + "\n"); break;
        case 2: int[] newArr = reverse();
        System.out.print("The reverse array is: ");
        //Prints out reversed array outputs one at a time
        for(int i : newArr) System.out.print(i + " ");
        System.out.println("\n");
        break;
        case 3: run(); break;
        case 4: System.out.println("Exiting..."); break;
        default: System.out.println("Invalid input! \n"); break;

      }
    }
  }

  public static int[] getValues() {
    int size = -1;

    //Get size of array must be at least 1
    while(size < 1) {
      System.out.print("How many integer values: ");
      size = keys.nextInt();
      if(size < 1) System.out.print("\nInvalid Input!");
    }

    int[] values = new int[size];

    //Sets values to array positions
    System.out.print("Enter the numbers: ");
    for(int i = 0; i < size; i++) {
      values[i] = keys.nextInt();
    }

    //outputs an integer array
    return values;
  }

public static int alternatingSum() {
  System.out.println("** alternatingSum **");

  //sets array to values from getValues method
  int[] values = getValues();
  int sum = 0;

  for(int i = 0; i < values.length; i++) {
    //add even positions of array
    if(i%2 == 0) {
      sum += values[i];
    }
    //subtract odd positions of array
    else {
      sum -= values[i];
    }
  }

  //returns an integer
  return sum;
}

public static int[] reverse() {
  System.out.println("** reverse **");

  //sets values of array to users input in getValues method
  int[] values = getValues();
  //create new empty array of same length
  int[] reverse = new int[values.length];
  int count = 0;

  //sets reverse array to opposite order of getValues
  for(int i = values.length-1; i >= 0; i--) {
    reverse[count] = values[i];
    count++;
  }

  //return an integer array
  return reverse;
  }

  public static void run() {
    System.out.println("** run **");
    System.out.println("The sequence of numbers is: ");

    int[] dice = new int[20];
    boolean inRun = false;
    int count = 1, max = 0, start = 0;

    //sets values to the 20 spaces in the dice rolling array
    for(int i = 0; i <20; i++) {
      dice[i] = (int)(1 + Math.random()*6);
    }

    //check at each position of array
    for(int y = 0; y < 20; y++) {
      //check the last integer in array for max count
      if(y == dice.length - 1) {
        if(dice[y] == dice[y-1]) {
          if(count > max) {
            max = count;
            start = y - max;
          }
        }
      }
      //count continuous output of the same integer
      if(y > 0 && dice[y] == dice[y-1]) {
        count++;
      } else if (y > 0 && dice[y] != dice[y-1]) {
        if(count > max) {
          max = count;
          start = y - max;
        }
        count = 1;
      }
    }


    for(int x = 0; x < dice.length; x++) {
      //close parenthesis on longest run
      if(inRun == true) {
        if(dice[x] != dice[start]) {
          System.out.print(")");
          inRun = false;
        }
      }

      //space in between outputs
      if(x > 0) System.out.print(" ");

      //start parenthesis of longest run, based off start position of max count
      if(inRun == false) {
        if(x == start && dice[x] == dice[start]) {
          System.out.print("(");
          inRun = true;
        }
      }
      System.out.print(dice[x]);
    }

    //close parenthesis if not done before reaching end of array
    if(inRun == true) System.out.print(")");
    System.out.println("");
    System.out.println("");
  }
}
