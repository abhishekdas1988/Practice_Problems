package bloomberg;
import java.math.BigInteger;
import java.util.ArrayList;

public class PowerSet {
	public void powerSet(String s){
		StringBuilder given = new StringBuilder(s);
		int length = given.length();
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0;i<length;i++){
			list.add(Character.toString(given.charAt(i)));
		}
//		System.out.println("List size "+list.size());
		for(int i = 0;i<(Math.pow(2,(double)length));i++){
//			System.out.println("I"+i);
//			System.out.println("Number binary "+Integer.toBinaryString(123));
			// Use the length to check out how many digits we need to create a binary
			StringBuilder number = new StringBuilder(String.format("%16s", Integer.toBinaryString(i)).replace(" ", "0"));
//			System.out.println("Number length"+number.length());
			number = number.delete(0, number.length()-length);
			System.out.print("Number = "+number+" = " );
//			System.out.print("Entry = ");
			for(int j = 0;j<number.length();j++){
				if(number.charAt(j)=='1'){
					System.out.print(given.charAt(j));
					
				}
				
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		PowerSet sol = new PowerSet();
		sol.powerSet("ABCDEFG");
	}

}
