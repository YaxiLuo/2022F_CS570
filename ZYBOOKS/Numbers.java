package ZYBOOKS;
import java.util.LinkedList;
import java.util.ListIterator;

public class Numbers {
   public static void main(String[] args) {
      LinkedList<Integer> numbers = new LinkedList<Integer>();
      ListIterator<Integer> numIter;
      int nextNum;

      numbers.add(18);
      numbers.add(16);
      numbers.add(15);

      numIter = numbers.listIterator();
      while (numIter.hasNext()) {
         numIter.next();
      }

      numIter.remove();
      if (numIter.hasPrevious()) {
         numIter.previous();
      }
      numIter.set(17);

      numIter = numbers.listIterator();
      while (numIter.hasNext()) {
         nextNum = numIter.next();
         System.out.println(nextNum);
      }
   }
}