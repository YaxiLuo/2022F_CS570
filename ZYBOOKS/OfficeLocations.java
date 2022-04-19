package ZYBOOKS;

import java.util.Scanner;
import java.util.HashSet;

public class OfficeLocations {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      HashSet<String> offices = new HashSet<String>();
      String userInput;

      offices.add("Tokyo");
      offices.add("London");
      offices.add("Vancouver");
      offices.add("Sydney");

      userInput = scnr.nextLine();
      while (userInput.compareTo("done") != 0){
         if (offices.contains(userInput)) {
            System.out.println("c");
         }
        else {
           System.out.println("n");
         }
         userInput = scnr.nextLine();
      }

      System.out.println("Size: " + offices.size());
   }
}
