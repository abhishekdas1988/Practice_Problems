import java.io.*;
import java.util.*;
import java.util.Stack;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

//15 + 2 - 3
//1 1
class Solution {

	Stack<String> s = new Stack<String>();
	ArrayList<String> input = new ArrayList<String>();
	// maintaining a counter to check if we have any precedence problems for
	// future pushes
	static int counter = 0;

	public void validateString(String inp) {
		String[] s = inp.split(" ");
		for (int i = counter; i < s.length; i++) {
			// System.out.println(" val " + s[i]);
			input.add(s[i]);
		}
		// checking for valid input strings. number count - operator count =1
		int numberCount = 0;
		int operatorCount = 0;
		for (String str : input) {
			// we created isNumber funtion, lets use that
			if (this.isNumber(str)) {
				numberCount++;
			} else {
				operatorCount++;
			}
		}
		if ((numberCount - operatorCount) != 1) {
			System.out.println("Invalid String, exiting with code 1");
			System.exit(1);
		}

	}

	public boolean isNumber(String s) {
		// if its a number
		// Changed this.
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public boolean precedence() {
		for (String s : this.input) {
			if (s.compareTo("*") == 0 || s.compareTo("/") == 0) {
				return true;
			}
		}
		return false;
	}

	public int eval() {

		String add = "+";
		String sub = "-";
		String multiply = "*";
		String divide = "/";
		// Build pushing
		int counter = 0;
		for (int i = 0; i < this.input.size(); i++) {
			System.out.println(" Iterration i =" + i);
			if (this.input.get(i).compareTo(multiply) == 0 || this.input.get(i).compareTo(divide) == 0) {

				String operator = this.input.get(i);
				Integer operand1 = Integer.parseInt(s.pop());
				Integer operand2 = Integer.parseInt(this.input.get(i + 1));
				System.out.println("i = " + i);
				if (operator.compareTo(multiply) == 0) {
					System.out.println("Pushing " + operand1 * operand2);
					s.push((new Integer(operand1 * operand2)).toString());
					System.out.println("Top " + s.peek());
					i = i + 1;
				} else {
					System.out.println("Pushing " + operand1 / operand2 + "  Separate " + operand1 + " " + operand2);
					s.push((new Integer(operand1 / operand2)).toString());
					System.out.println("Top " + s.peek());
					// The issue was here, I added the print statements to find
					// that.
					// The issue was even though we carried out 6*3 from the
					// string
					// 6 * 3 * 2, the for loop would still consider 3 as the
					// next
					// element, instead of * after 3. Hence i just incremented
					// the i
					// value
					i = i + 1;
				}

			} else if (this.isNumber(this.input.get(i))) {
				System.out.println("Pushing else if - " + this.input.get(i) + " i =" + i);
				s.push(this.input.get(i));

			}
			// final case if the Operator is addition or subtraction
			else {
				if (this.input.get(i).compareTo(add) == 0 || this.input.get(i).compareTo(sub) == 0) {
					if (this.precedence()) {
						System.out.println("Pushing else if - " + this.input.get(i) + " i =" + i);
						s.push(this.input.get(i));
					} else {
						String operator = this.input.get(i);
						Integer operand1 = Integer.parseInt(s.pop());
						Integer operand2 = Integer.parseInt(this.input.get(i + 1));
						System.out.println("i = " + i);
						if (operator.compareTo(add) == 0) {
							System.out.println("Pushing " + (operand1 + operand2));
							s.push((new Integer(operand1 + operand2)).toString());
							System.out.println("Top " + s.peek());
							// The issue was here, I added the print statements
							// to find that.
							// The issue was even though we carried out 6*3 from
							// the string
							// 6 * 3 * 2, the for loop would still consider 3 as
							// the next
							// element, instead of * after 3. Hence i just
							// incremented the i
							// value
							i = i + 1;
						} else {
							System.out.println(
									"Pushing " + (operand1 - operand2) + "  Separate " + operand1 + " " + operand2);
							s.push((new Integer(operand1 - operand2)).toString());
							System.out.println("Top " + s.peek());
							// The issue was here, I added the print statements
							// to find that.
							// The issue was even though we carried out 6*3 from
							// the string
							// 6 * 3 * 2, the for loop would still consider 3 as
							// the next
							// element, instead of * after 3. Hence i just
							// incremented the i
							// value
							i = i + 1;
						}
					}
				}
			}
			System.out.println(" ----------------------- ");
		}
		// At this point we might be done or only left with additions and
		// subtractions
		if (s.size() == 1) {
			return Integer.parseInt(s.pop());
		} else {
			// Reversing the stack because i need to honor the order of the
			// string from left to right.
			Stack<String> rev = new Stack<String>();
			while (!s.isEmpty()) {
				rev.push(s.pop());
			}
			while (rev.size() != 1) {
				System.out.println("Rev size " + rev.size());
				Integer operand1 = Integer.parseInt(rev.pop());
				String operator = rev.pop();
				Integer operand2 = Integer.parseInt(rev.pop());
				if (operator.compareTo(add) == 0) {
					System.out.println("Pushing " + (operand1 + operand2));
					rev.push((new Integer(operand1 + operand2)).toString());
					System.out.println("Top " + rev.peek());
				} else {
					System.out.println("Pushing " + (operand1 - operand2) + "  Separate " + operand1 + " " + operand2);
					rev.push((new Integer(operand1 - operand2)).toString());
					System.out.println("Top " + rev.peek());
				}

			}
			return Integer.parseInt(rev.pop());
		}

	}

	public static void main(String[] args) {

		Solution s = new Solution();
		// s.validateString("2 * 6 / 4");
		// System.out.println("*********************************");
		s.validateString("10 - 6 / 6 + 3 * 2");
		System.out.println("Solution - " + s.eval());

	}
}

/*
 * asa@optimizely.com *
 *
 * Your previous Plain Text content is preserved below:
 * 
 * Write a function/method that takes a mathematical expression represented as a
 * string and returns the value of the expression.
 * 
 * The expression is written in infix notation (number operator number) with a
 * single space between operators and numbers.
 * 
 * You only need to support four operations: addition, subtraction, division and
 * multiplication (+ - * /). There are no parenthesis.
 * 
 * Valid input: "15 + 2 - 3" -> 14 "1 + 233 / 233" -> 2 "145" -> 145
 * "2 * 3 + 12 / 6" -> 8 "2 + 2 * 3 + 3" -> 11
 * 
 * Throw an exception or raise an error if you encounter invalid input.
 * 
 * Invalid input: "1 1" "+ 1" "1 + 2 +" "+ 1 1" Asa: asa@optimizely.com
 * 
 * 
 */