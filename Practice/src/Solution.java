public class Solution {
	static boolean is_number(String toTest) {
		boolean hasNonZeroChar = false;
		int decimal = 0;
		boolean retVal = true;

		for (int i = 0; i < toTest.length(); i++) {
			char c = toTest.charAt(i);
			// This will fail for "." which is not a valid number.
			if (c == '.') {
				if (decimal == 0) {
					decimal = decimal + 1;
					continue;
				} else {
					return false;
				}
			} else if (c >= '1' && c <= '9')
				hasNonZeroChar = true;
			else if (c == '0') {
				if (!hasNonZeroChar) {
					if (i < toTest.length() - 1) {
						if (toTest.charAt(i + 1) == '.' && decimal == 0)
							continue;
						else if (decimal == 1 && (toTest.charAt(i + 1) >= 0 || toTest.charAt(i + 1) <= 9)) {
							continue;
						} else
							return false;
					} else
						break;
				}
			} else if (c == '-') {
				if (i != 0)
					return false;
			}
			else if(!Character.isDigit(c) || Character.isSpaceChar(c)){
				return false;
			}
			
		}
		return true;

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.is_number(""));

	}
}