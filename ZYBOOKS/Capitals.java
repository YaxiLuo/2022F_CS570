package ZYBOOKS;

import java.util.Scanner;
import java.util.HashMap;

public class Capitals {
   public static void main (String[] args) {
      HashMap<String, String> countryCapital = new HashMap<String, String>();
      Scanner scnr = new Scanner(System.in);
      String countryName;

      countryCapital.put("Spain", "Madrid");
      countryCapital.put("Italy", "Rome");
      countryCapital.put("Egypt", "Cairo");
      countryCapital.putIfAbsent("Italy", "Lima");
      countryCapital.putIfAbsent("Austria", "Vienna");

      countryName = scnr.next();
      while (!countryName.equals("exit")) {
         System.out.print(countryName + ": ");
         System.out.println(countryCapital.get(countryName));
         countryName = scnr.next();
      }
   }
}