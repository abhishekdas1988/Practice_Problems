import java.util.Stack;

public class MaxContigousAreaHistogram {

	public int max(int[] input) {
		Stack<Integer> s = new Stack<Integer>();
		int max_area = 0;
		int area = 0;
		int i = 0;
		for (i = 0; i < input.length;) {
			if (s.isEmpty() ||( input[i] >= input[s.peek()])) {
				s.push(i++);
				System.out.println("Element pushed - "+s.peek());
			} else {
				int top = s.pop();
				if (s.isEmpty()) {
					area = input[top] * i;
				} else {
					area = input[top] * (i - s.peek() - 1);
				}
				if (area > max_area) {
					max_area = area; 
				}
			}
		}
		while (!s.isEmpty()) {
			int top = s.pop();
			if (s.isEmpty()) {
				area = input[top] * i;
			} else {
				area = input[top] * (i - s.peek() - 1);
			}
			if (area > max_area) {
				max_area = area;
			}
		}

		return max_area;
	}

	public static void main(String[] args) {
		MaxContigousAreaHistogram o = new MaxContigousAreaHistogram();
		int[] i = { 2,1, 2,4 };
		System.out.println(o.max(i));
	}
}
