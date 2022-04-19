package ZYBOOKS;
import java.util.HashMap;

public class AirportCodes {
   public static void main (String[] args) {
      HashMap<String, String> airportCode = new HashMap<String, String>();

      airportCode.put("IWJ", "Iwami, Japan");
      airportCode.put("LNZ", "Linz, Austria");
      airportCode.put("MLN", "Melilla, Spain");

      System.out.print("MLN: ");
      System.out.println(airportCode.get("MLN"));

      airportCode.put("IWJ", "Ivalo, Finland");

      System.out.print("IWJ: ");
      System.out.println(airportCode.get("IWJ"));
   }
}