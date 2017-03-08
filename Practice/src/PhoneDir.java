import java.util.Random;
import java.util.*;
public class PhoneDir {
	String[] curr = {"0","0","abc","def","ghi","jkl","mno","pqrs","tuvw","xyz"};
	List<String> val = new LinkedList<String>();

	public void getCombo(String input){
		String[] in_arr = new String[input.length()];
		int i;
		for(i = 0;i< input.length();i++){
			in_arr[i]= curr[Integer.parseInt(Character.toString(input.charAt(i)))];
			this.Combo("",in_arr[i]);

		}
	}
	public void Combo(String prefix,String s){
		int n = s.length();
		if(n==0){
			this.val.add(prefix);
		}
		else{
			for(int i=0;i<n;i++){
				this.Combo(prefix+s.charAt(i),s.substring(0, i)+s.substring(i+1,n) );
			}
		}
		
//		

	}
	
	public static void main(String[] args){
		PhoneDir a =new PhoneDir();
		a.getCombo("23");
		for(String s:a.val){
			System.out.println(s);
		}
	}

}
