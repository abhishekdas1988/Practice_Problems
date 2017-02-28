package bloomberg;

public class ZeroEnd {
public static void print(int[] a){
	for (int i = 0;i<a.length;i++){
		System.out.print(a[i]+" ");
	}
	System.out.println();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,0,2,5,0,4,0};
		int pos = 0;
	  	for(int i = 0; i < a.length; i++)
	  		if(a[i] != 0)
	  			a[pos++] = a[i];
	  	print(a);
	  	for(int i = pos; i < a.length; i++)
	  		a[i] = 0;
	  	print(a);
		for(int i = 0;i< a.length;i++){
			System.out.println(a[i]);
		}

	}

}
