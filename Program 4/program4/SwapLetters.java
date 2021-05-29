/*
Name: Myles Cagle
Date: 9/22/2019
Section: C
Description: Swaps two letters in any given word
*/


import java.util.Scanner;

public class SwapLetters {
  
  public static void main(String[] args) {
    //Initialize variables for program
    int i,j;
    String word, newWord;
    Scanner keys = new Scanner(System.in);

    //Declare word to have letters swapped
    System.out.print("Enter a word: ");
    word = keys.nextLine();
    //Decide which to letters to swap based on placement in string
    System.out.printf("%nEnter two values for i and j between (0-%d)",(word.length()-1));
    i = keys.nextInt();
    j = keys.nextInt();

    //Uses two positions to swap characters and declare new word
    newWord = word.substring(0,i)+word.substring(j,j+1)+word.substring(i+1,j)+
      word.substring(i,i+1)+word.substring(j+1);

    //Outputs swapped character word
    System.out.printf("** %s **",newWord);

    keys.close();
  }
}
