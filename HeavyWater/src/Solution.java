import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	static String[] braces(String[] values) {
		Map<String, String> bank = new HashMap<String, String>();
		bank.put( "}","{");
		bank.put( ")","(");
		bank.put( "]","[");
		Stack<String> balancer = new Stack<String>();
		String[] retVal = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			String curr = values[i];
			if (curr.length() % 2 != 0) {
				retVal[i] = "NO";
			} else {
				int j = 0;
				while(j<curr.length()){
					if(bank.containsKey(Character.toString(curr.charAt(j)))){
						if(balancer.isEmpty()){
							retVal[i]="NO";
						}
						String poped = balancer.pop();
						if(bank.get(Character.toString(curr.charAt(j))).compareTo(poped)==0){
							retVal[i] = "YES";
						}
						else{
							retVal[i] = "NO";
						}
					}
					else{
						balancer.push(Character.toString(curr.charAt(j)));
					}
					j++;
				}

			}
		}
		return retVal;
	}
	public static void main(String[] args){
		String[] test = {"{}[]()","{[}]"};
		String[] ret = Solution.braces(test);
		for(int i = 0;i<ret.length;i++){
			System.out.println(ret[i]);
		}
	}
}
