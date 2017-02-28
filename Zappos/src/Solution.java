import java.util.HashMap;
import java.util.Map;

public class Solution {

	static String[] braces(String[] values) {
		String s = "{[()]}";
		int number_input = values.length;
		String[] ret = new String[number_input];
		for (int i = 0; i < number_input; i++) {
			System.out.println("ROUND " + i + "-------------------------------");
			if (number_input % 2 != 0) {
				ret[i] = "NO";
				break;
			} else {
				Map<String, Integer> store = new HashMap<String, Integer>();
				String curr = values[i];
				for (int j = 0; j < curr.length(); j++) {
					System.out.println("Current char = "+curr.charAt(j));
					System.out.print("Store currently contains = <<");
					for(String keys:store.keySet()){
						System.out.print(keys+" ,");
					}
					System.out.print(">>");
					System.out.println();
					if (store.containsKey(curr.charAt(j))) {
						System.out.println("Contains " + curr.charAt(j));
						store.put(Character.toString(curr.charAt(j)), store.get(curr.charAt(j)) + 1);
					} else {
						System.out.println("Putting new val " + curr.charAt(j));
						store.put(Character.toString(curr.charAt(j)), 1);
					}
				}
				for (String key : store.keySet()) {
					System.out.println("Current key = " + key + " curr val = " + store.get(key));
					if (store.get(key) % 2 != 0) {
						ret[i] = "NO";
						break;
					}
				}

			}
		}
		return ret;
	}
	public static void main(String [] args){
		Solution s = new Solution();
		String[] val = {"{}(){}","{}})("};
		String[] ret = s.braces(val);
		for(int i = 0;i<ret.length;i++){
			System.out.println("i ="+ ret[i]);
		}
	}
}
