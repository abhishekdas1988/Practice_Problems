import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-making-anagrams
public class MinimumDeleteToAnagram {
	public static int numberNeeded(String first, String second) {
		// Sorting the strings out
		String master = first.concat(second);
		List<Character> first_S = new ArrayList<Character>();
		List<Character> second_S = new ArrayList<Character>();
		;
		for (int i = 0; i < first.length(); i++) {
			first_S.add(first.charAt(i));
		}
		for (int i = 0; i < second.length(); i++) {
			second_S.add(second.charAt(i));
		}
		// List<Character> first_S = Collections.sort(first.toCharArray());

		return (master.length() - 2 * (MinimumDeleteToAnagram.matchNumber(first_S, second_S)));
	}

	public static int matchNumber(List<Character> first, List<Character> second) {
		int count = 0;
		Map<Character, Integer> bank = new HashMap<Character, Integer>();
		if (first.size() <= second.size()) {
			for (Character s : second) {
				if (bank.containsKey(s)) {
					bank.put(s, bank.get(s) + 1);
				} else {
					bank.put(s, 1);
				}
			}
			for (Character s : first) {
				if (bank.containsKey(s) && bank.get(s) >= 1) {
					count++;
					bank.put(s, bank.get(s) - 1);
				}
			}
		} else {
			for (Character s : first) {
				if (bank.containsKey(s)) {
					bank.put(s, bank.get(s) + 1);
				} else {
					bank.put(s, 1);
				}
			}
			for (Character s : second) {
				if (bank.containsKey(s) && bank.get(s) >= 1) {
					count++;
					bank.put(s, bank.get(s) - 1);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}
