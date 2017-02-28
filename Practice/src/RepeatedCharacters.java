import java.util.Arrays;
import java.util.Comparator;

import javax.xml.stream.events.Characters;

public class RepeatedCharacters implements Comparator<Character> {
	

	public String repeats(String s){
		if(s.length()==0 || s==null){
			return "";
		}
		StringBuilder retVal = new StringBuilder();
		char[] c_arr = s.toCharArray();
		Arrays.sort(c_arr);
		for(int i = 0;i< c_arr.length;i++){
			System.out.print(c_arr[i]+ " ");
		}
		System.out.println();
		int count = 1;
		char curr = c_arr[0];
		for(int i = 1;i<c_arr.length;i++){
			System.out.println("Comparing - "+c_arr[i]+ " with "+ curr);
			System.out.println("Current curr - "+curr);
			System.out.println("Current count - "+count);
			if(Character.compare(curr, c_arr[i])!=0){
				retVal.append(count);
				retVal.append(curr);
				count = 1;
				curr = c_arr[i];
			}
			else{
				count++;
			}
		}
		return retVal.toString();
	}

	public int compare(Character o1, Character o2) {
		// TODO Auto-generated method stub
		return Character.compare(Character.toLowerCase(o1),Character.toLowerCase(o2));
	}


public static void main(String[] args){
	RepeatedCharacters s = new RepeatedCharacters();
	System.out.println(s.repeats("aaaggbbbbc"));
}
}
