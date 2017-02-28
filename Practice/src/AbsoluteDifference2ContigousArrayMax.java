import java.util.*;
import java.lang.*;
import java.io.*;
//[-2, -3, 4, -1, -2, 1, 5, -3]
class AbsoluteDifference2ContigousArrayMax {
    public int max(int[] a){
     // Max absolute difference would be when one is max of 
     // the array and one is the min of the array.
        int max_curr = a[0];
        int max_so_far = a[0];
        int min_curr = a[0];
        int min_so_far =a[0];
        for(int i = 0;i<a.length;i++){
            max_curr = (Math.max(a[i],max_curr+a[i]));
            max_so_far = (Math.max(max_curr,max_so_far));
        }
        for(int i = 0;i<a.length;i++){
            min_curr = (Math.min(a[i],max_curr+a[i]));
            min_so_far = (Math.max(min_curr,min_so_far));
        }
        return (Math.abs(max_so_far - min_so_far));

    }
	public static void main (String[] args) {
		AbsoluteDifference2ContigousArrayMax obj = new AbsoluteDifference2ContigousArrayMax
				();
	    Scanner in = new Scanner(System.in);
	    int no_input = in.nextInt();
	    for(int i = 0;i< no_input;i++){
	    	int size =(in.nextInt());
	    	in.nextLine();
	    	String inp = in.nextLine();
	    	//System.out.println("Input is "+inp);
	    	String[] inp_s = inp.split(" ");
	    	//System.out.println("Size of input "+inp_s.length);
	    	int[] input = new int[size];
	    	for(int j=0;j<inp_s.length;j++){
	    		input[j] = Integer.parseInt(inp_s[i]);
	    	}
	    	System.out.println(obj.max(input));
	    }
		
	}
}