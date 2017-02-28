import java.util.Stack;
public class ReverseWordString {
	private static String st;
	
	public ReverseWordString(String st){
		this.st = st;
	}
	
	public void reverseCharInWord(){
		String[] st_arr = this.st.split("\\s");
		for(String s: st_arr){
			char[] curr = s.toCharArray();
			for(int i = curr.length-1;i>=0 ;i--){
				System.out.print(curr[i]);
			}
			System.out.print(" ");
		}
		System.out.println();
		
	}
	public void reverseWord(){
		String[] st_arr = this.st.split("\\s");
		for(int i =st_arr.length-1;i>=0;i--){
			System.out.print(st_arr[i]+" ");
		}
	}
	public static void main(String[] args){
		ReverseWordString sol = new ReverseWordString("The Girl In A Red Dress");
		sol.reverseCharInWord();
		sol.reverseWord();
	}

}
