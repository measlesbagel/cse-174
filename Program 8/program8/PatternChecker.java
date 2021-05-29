/*
Name: Myles Cagle
Date: 10/20/2019
Section: C
Description:
  Creates a pattern checking program where
  the user selects what pattern to check for and after
  proper input the correct answer is displayed.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class PatternChecker {
  //global scanner for other methods
  public static Scanner keys = new Scanner(System.in);

  public static void main(String[] args){
    int choice = 4;
    //create menu with loop
    while(choice != 3) {
      System.out.println("List of Pattern Checker problems: ");
      System.out.println("1) Largest and Smallest pairs");
      System.out.println("2) Counting digits");
      System.out.println("3) Quit");
      System.out.print("Choice: ");
      choice = keys.nextInt();

      switch(choice){
        case 1: largeSmall(); break;
        case 2: countDigits(); break;
        case 3: System.out.println("*** End"); break;
        default: System.out.println("Invalid input \n"); break;
      }
    }
  }

  public static void largeSmall() {
    int num, count = -1, large = Integer.MIN_VALUE, largest = Integer.MIN_VALUE,
      small = Integer.MAX_VALUE, smallest = Integer.MAX_VALUE, i = 0, x = 0;
    //makes sure limit it at least 2
    while(count < 2) {
      System.out.print("Enter the limit: ");
      count = keys.nextInt();
      if(count >= 2) {
        System.out.printf("%nEnter %d numbers: ", count);

        while(i < count) {
          num = keys.nextInt();
          //finds largest and sets large to previous number unless there are less than 3 numbers
          if(num > largest) {
            large = largest;
            largest = num;
          } else if (num > large && num != largest) {
            large = num;
          }

          //finds smallest number and sets small to previous number unless there are less than 3 numbers
          if(num < smallest) {
            small = smallest;
            smallest = num;
          } else if (num < small && num != smallest) {
            small = num;
          }

          i++;
        }
      }
      // tell user input needs to be atleast 2
      else System.out.println("Invalid input. The limit should be at least 2.");
    }

    System.out.printf("*** Largest and Smallest Pairs: (%d, %d), (%d, %d) %n",largest,large,smallest,small);
  }

  public static void countDigits() {
    int digit = -1, prevDigit = -1, count, i = 0, num = 1000000 + (int)(Math.random()*1000000), prevNum = -1;
    //keeps track of all previous digits to compare against for output
    ArrayList<Integer> arrInt = new ArrayList<Integer>();

    System.out.println("The generated random number is " + num);
    System.out.print("*** Counted pairs are = ");

    while(num > 0) {
      count = 1;
      prevDigit = digit;
      digit = num%10;
      num /= 10;
      prevNum = num;
      while(prevNum > 0) {
        if(prevNum%10 == digit) count++;
        prevNum /= 10;
      }
      // adds next digit count to output if not previously listed
      if(arrInt.contains(digit) == false) System.out.printf("(%d, %d) ",digit,count);
      // adds current digit to arraylist
      arrInt.add(digit);
    }
    //creates a blank line between output and menu
    System.out.println("\n");
  }

}
