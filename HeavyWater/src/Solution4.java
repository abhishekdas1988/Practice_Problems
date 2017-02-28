
public class Solution4 extends Solution3{
//	public Solution3 getSuperclass(){
//		
//	}
	public static void main(String[] args){
		Solution4 s = new Solution4();
		Solution3 s1= s.getFood("ff");
		Solution3 s2= s.getFood("ff");

		System.out.println("My name is : "+s1.getClass().getName());

		System.out.println("My name is : "+s2.getClass().getName());
		//System.out.println("Out super class is "+s1.get);
	}
	

}
