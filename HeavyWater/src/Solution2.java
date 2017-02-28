import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	public int mymethod(int a, int b) throws Exception {
		if (a < 0 || b < 0) {
			return a * b;
		} else {
			throw new Exception("Hello");
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		List<Integer> input = new LinkedList<Integer>();
		while (in.hasNextLine()) {
			String[] curr = in.nextLine().split("\\s+");
			for (int i = 0; i < curr.length; i++) {
				input.add(Integer.parseInt(curr[i]));
			}
		}
		for (int i = 0; i < input.size(); i = i + 2) {
			try {
				System.out.println(" i " + i);
				System.out.println(new Solution2().mymethod(input.get(i), input.get(i + 1)));
			} catch (Exception e) {
				System.out.println("java.lang.Exception: n and p should be non-negative");
			}
		}
	}
}
