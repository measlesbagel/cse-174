//This program takes a unknown list of integers and rewrites it with first and last integer flipped

import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileExcercise {
  public static void main(String[] args) throws FileNotFoundException {
   File file = new File("numbers.txt");
   Scanner fileScanner = new Scanner(file);
   
   ArrayList<Integer> arr = new ArrayList<Integer>();
   
   while(fileScanner.hasNext()) {
     if(fileScanner.hasNextInt()) {
       int num = fileScanner.nextInt();
       arr.add(num);
     } else fileScanner.next();
   }
   
   int temp = arr.get(0);
   arr.set(0,arr.get(arr.size()-1));
   arr.set(arr.size()-1,temp);
   
   PrintWriter out = new PrintWriter(file);
   
   for(Integer num : arr) {
    out.println(num); 
   }
    
   out.close();
   
   System.out.print(arr);
  }
}