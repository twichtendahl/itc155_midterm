import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MaxOccurrences {

	public static void main(String[] args) {
		//Tests that empty list returns 0
		List<Integer> list1 = new ArrayList<Integer>();
		System.out.println("The following output should be 0: maxOccurences = " + maxOccurrences(list1));
				
				
		//Tests a simple example where 5 occurs three times
		list1.add(1);
		list1.add(1);
		list1.add(2);
		list1.add(5);
		list1.add(5);
		list1.add(2);
		list1.add(5);
		System.out.println("The following output should be 3: maxOccurences = " + maxOccurrences(list1));
				
		//Tests with a Linked List instead of Array List
		List<Integer> list2 = new LinkedList<Integer>();
		System.out.println("The following output should be 0: maxOccurences = " + maxOccurrences(list2));
				
		//Now tests for when there's a tie
		list1.clear();
		list1.add(1);
		list1.add(1);
		list1.add(2);
		list1.add(5);
		list1.add(5);
		list1.add(2);
		System.out.println("The following output should be 2: maxOccurences = " + maxOccurrences(list1));
	}
	
	/* Problem 1. Accepts a LIST of integers as a parameter
	 * and returns the number of times the most frequently 
	 * occurring integer (the "mode") occurs. */
	public static int maxOccurrences(List<Integer> list) {
		//Empty list should return '0'
		if(list.size() == 0) {
			return 0;
		}
		
		// Construct Map for auxiliary storage.
		Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		
		// Construct Iterator over the list
		Iterator<Integer> iterator = list.iterator();
		
		/* The map is going to associate each integer in the list (key)
		 * with the count of that integer in the list (value). To do 
		 * this it must first check to see that the value exists as a
		 * key, creating that key if not and initializing it as a
		 * count of 1. Otherwise, increment the value. */
		while(iterator.hasNext()) {
			int number = iterator.next();
			if(!numbers.containsKey(number)) {
				numbers.put(number, 1);
			} else {
				numbers.put(number, numbers.get(number) + 1);
			}
		}
		
		// Bring the data back into list to sort and find the maximum value.
		List<Integer> counts = new ArrayList<>(numbers.values());
		Collections.sort(counts);		
		return counts.get(counts.size() - 1);
	}
	
	/* Problem 2
	 * 
	 * mystery1( [2, 6, 1, 8] ) = [1, 2, 6, 8]
	 * mystery1( [30, 20, 10, 60, 50, 40] ) = [10, 30, 40, 20, 60, 50]
	 * mystery1( [-4, 16, 9, 1, 64, 25, 36, 4, 49] ) = [-4, 1, 25, 49, 16, 9, 64, 36, 4]
	 */
	
	/* Problem 3
	 * 
	 * mystery3(6) returns 6
	 * mystery3(17) returns 8
	 */
}