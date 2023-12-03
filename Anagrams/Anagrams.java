
/**
 * @author Rishikesh Yadav CWID : 20007668
 *
 *
 **********************---UML---*****************************************
------------------------- Anagrams -------------------------------------*
final Integer[] primes;                                                 *
Map<Character,Integer> letterTable;                                     *
Map<Long,ArrayList<String>> anagramTable;                               *
------------------------------------------------------------------------*
public Anagrams ()                                                      *
private void buildLetterTable()                                         *
private void addWord(String s)                                          *
private Long myHashCode(String s)                                       *
public void processFile(String s) throws IOException                    *
private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries()    *
public static void main(String[] args)                                  *
 ************************************************************************
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Anagrams {

	final Integer[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
			89, 97, 101 };

	Map<Character, Integer> letterTable;
	Map<Long, ArrayList<String>> anagramTable;

	/** Constructor for invoking buildLetterTable method */
	public Anagrams() {
		buildLetterTable();
		anagramTable = new HashMap<Long, ArrayList<String>>();

	}

	/** Letter table used for hashing */
	private void buildLetterTable() {
		letterTable = new HashMap<Character, Integer>();
		Character[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		for (int i = 0; i < 26; i++) {
			letterTable.put(alphabet[i], primes[i]);
		}

	}

	/** Compute hash code and add the word in the hash table */
	private void addWord(String s) {

		Long myHash = this.myHashCode(s);
		if (anagramTable.get(myHash) == null) {
			ArrayList<String> wordList = new ArrayList<String>();
			wordList.add(s);
			anagramTable.put(myHash, wordList);
		} else {
			anagramTable.get(myHash).add(s);
		}
	}

	private Long myHashCode(String s) {
		long keyHash = 1;
		for (int a = 0; a < s.length(); a++) {
			keyHash = keyHash * (long) letterTable.get(s.charAt(a));
		}
		return keyHash;
	}

	private void processFile(String s) throws IOException {

		FileInputStream fStream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
		String strLine;

		while ((strLine = br.readLine()) != null) {
			this.addWord(strLine);
		}
		br.close();
	}

	/** This function will return entry with most anagram */
	private ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries() {

		ArrayList<Map.Entry<Long, ArrayList<String>>> aList = new ArrayList<>();
		int maxValue = 0;

		for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {

			if (entry.getValue().size() > maxValue) {
				aList.clear();
				aList.add(entry);
				maxValue = entry.getValue().size();
			} else if (entry.getValue().size() == maxValue) {
				aList.add(entry);
			}
		}
		return aList;

	}
	
	/** main Function */
	public static void main(String[] args) {

		String current = System.getProperty("user.dir");
		Anagrams a = new Anagrams();

		final long startTime = System.nanoTime();

		try {
			a.processFile(current + "\\words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
		// 自己加的，需要搞清楚是什么！！！
		long key = maxEntries.get(0).getKey();
		int length = maxEntries.get(0).getValue().size();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime / 1000000000);
		System.out.println("Elapsed Time : " + seconds);
		System.out.println("Key of maximum anagrams: " + key);
		System.out.println("List of max anagrams: " + maxEntries.get(0).getValue());
		System.out.println("Length of list of max anagrams : " + length);

	} // end of main

} // end of class
