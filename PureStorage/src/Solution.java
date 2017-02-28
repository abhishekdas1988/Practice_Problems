
public class Solution {
	int Func(int n){
		if (n==4)
			return 2;
		else 
			return 2*Func(n+1);
	}
	
	public static void main(String [] args){
		Solution s = new Solution();
		System.out.println(s.Func(2));
		
		
	}

}
