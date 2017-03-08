
public class PhoneBookProblem {
	String[] dict = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	String[] solution;

	public void createCombination(String input) {
		// find the size of the output.
		int total_size = 1;
		for (int i = 0; i < input.length(); i++) {
			total_size = total_size * (dict[Integer.parseInt(Character.toString(input.charAt(i)))]).length();
		}
		solution = new String[total_size];
		for (int i = 0; i < input.length(); i++) {
			// System.out.println(
			// "length of chars " + (double)
			// dict[Integer.parseInt(Character.toString(input.charAt(i)))].length());
			// System.out.println("Raising to power " + Math.abs((input.length()
			// - 1) - i));
			int char_repeat_freq = (int) Math.pow(
					(double) dict[Integer.parseInt(Character.toString(input.charAt(i)))].length(),
					(double) Math.abs((input.length() - 1) - i));
			// System.out.println("Filling " +
			// dict[Integer.parseInt(Character.toString(input.charAt(i)))]
			// + " - frequency " + char_repeat_freq);
			this.fillCharacter(char_repeat_freq, dict[Integer.parseInt(Character.toString(input.charAt(i)))]);
		}
	}

	public void fillCharacter(int freq, String ch) {
		int count = freq;
		int index = 0;
		for (int i = 0; i < solution.length; i++) {
			if (count == 0) {
				index++;
				count = freq;
				if (index == ch.length()) {
					index = 0;
				}
				if (solution[i] == null) {
					solution[i] = "";
				}
			}
			if (solution[i] == null) {
				solution[i] = "";
			}
			solution[i] = solution[i].concat(Character.toString(ch.charAt(index)));
			count--;

		}

	}

	public static final void main(String[] args) {
		PhoneBookProblem s = new PhoneBookProblem();
		s.createCombination("2934");
		System.out.print("[");
		for (int i = 0; i < s.solution.length; i++) {
			System.out.print(s.solution[i] + " , ");
		}
		System.out.print("]");
		System.out.println();
	}

}
