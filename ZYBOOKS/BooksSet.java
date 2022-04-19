package ZYBOOKS;

import java.util.Scanner;
import java.util.HashSet;

public class BooksSet {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      HashSet<String> books = new HashSet<String>();
      String userInput;

      userInput = scnr.nextLine();
      while (userInput.compareTo("done") != 0) {
         if (books.add(userInput)) {
            System.out.println("a");
         }
         else {
            System.out.println("n");
         }
         userInput = scnr.nextLine();
      }

      System.out.println("Size: " + books.size());
   }
}