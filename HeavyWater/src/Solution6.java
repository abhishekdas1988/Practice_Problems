
public class Solution6 extends Solution5{

	@Override
	int add(int a, int b) {
		// TODO Auto-generated method stub
		
		System.out.println(this.getClass().getSuperclass().getName());
		return a+b;
	}
	public static void main(String[] args){
		System.out.println(new Solution6().add(3, 2));
	}

}
