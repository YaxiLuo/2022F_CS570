package ZYBOOKS;

import java.util.Scanner;
import java.util.HashSet;

public class GroceryList {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      HashSet<String> groceries = new HashSet<String>();
      String userInput;

      groceries.add("noodles");
      groceries.add("soda");
      groceries.add("bananas");
      groceries.add("milk");
      groceries.add("chips");
      groceries.add("tomatoes");

      userInput = scnr.nextLine();
      while (userInput.compareTo("done") != 0){
         if (groceries.remove(userInput)) {
            System.out.println("r");
         }
         else {
            System.out.println("n");
         }
         userInput = scnr.nextLine();
      }

      System.out.println("Size: " + groceries.size());
   }
}