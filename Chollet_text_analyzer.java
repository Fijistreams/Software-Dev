/*
 * Dominick Chollet
 * Chollet_text_analyzer
 * CEN 3024
 */
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
//import javafx.application.Application;
/**
 * Provides methods to analyze a file and output frequencies of each word in the file
 * @author Dominick
 *
 */
public class Chollet_text_analyzer {
	
	//Method to create a scanner object
	/**
	 * Creates a object of type Scanner and handles FileNotFoundException
	 * @return Scanner object
	 */
	public Scanner makeScanner() {
		
		File file = new File("C:\\Users\\Dominick\\Desktop\\CEN3024\\Chollet_text_analyzer\\src\\macbeth.txt");
		Scanner scan = null;
		
		// Try catch to catch exception
		try {
			scan = new Scanner(file);
		
		}
		
		catch(FileNotFoundException e) {
			
			System.out.println("File Not Found");
			
		}
		return scan;
	}
	/**
	 * Prints out the results.
	 * @param frequencyList List of words
	 * @param wordMap Hashmap of words and their frequencies
	 */
	public void printList(List<String> frequencyList, HashMap<String, Integer> wordMap) {
		
		int i = 0;
		while(i < 19) {
			System.out.println("Word = " +"("+frequencyList.get(i)+")" + " " + "Frequency: " + wordMap.get(frequencyList.get(i)));
			i = i + 1;
		}
		
	}
	/**
	 * Method to find all the words in said file and count their frequencies
	 * @return HashMap Returns a hashmap of the words and their frequencies.
	 */
	public HashMap<String, Integer> fillMap() {
		
		Chollet_text_analyzer nobject = new Chollet_text_analyzer();
		Scanner scan = nobject.makeScanner();
		
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>(); //Using a hashmap to store file 
		
		//Custom delimiter to discard anything that isnt a letter
		//While loop stores all words as lowercase and sets values to 1
		scan.useDelimiter("[^a-zA-Z]+");
		while(true) {
			if(scan.hasNext() == true) {
			String word = scan.next();
			
			wordMap.put(word.toLowerCase(), 0);
			
			}
			else { 
				scan.close();
				break;
			}
			
		}
		
		scan = nobject.makeScanner();
		scan.useDelimiter("[^a-zA-Z]+");
		
		//While loop to count iterations of each word
		while(true) {
			if(scan.hasNext() == true) {
			String word2 = scan.next().toLowerCase();
			wordMap.replace(word2, (wordMap.get(word2) + 1));
		
			}
			else {
				break;
			}
		}
		
		//Apostrophes made it so these counted as words
		wordMap.remove("s");
		wordMap.remove("d");
		
		return wordMap;
	}
	/**
	 * Method to sort the list based on frequency
	 * @param wordMap
	 * @return List<String>
	 */
	public List<String> sortList(HashMap<String, Integer> wordMap) {
		
		List<String> frequencyList = new ArrayList<String>(wordMap.keySet());
		Collections.sort(frequencyList, new Comparator<String>() {
		    @Override
		    public int compare(String s2, String s1) {
		        Integer frequency1 = wordMap.get(s1);
		        Integer frequency2 = wordMap.get(s2);
		        return frequency2.compareTo(frequency1);
		    }
		});
		Collections.reverse(frequencyList);
		return frequencyList;
	}
	
	public static void main(String[] args) {
		Chollet_text_analyzer object = new Chollet_text_analyzer();
		object.printList(object.sortList(object.fillMap()), object.fillMap());

		
	}


}
