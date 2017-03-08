import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//5 2  
//1 5 3 4 2 

public class DiffInArray {
  static Map<Integer,Integer> data = new HashMap<Integer,Integer>();  
  static int pairs(int[] a,int k) {
      /* Complete this function */
    int count =0;
    for(int i = 0;i< a.length;i++){
      if(data.containsKey(a[i])){
        //System.out.println("Creating");
        data.put(a[i],data.get(a[i])+1);
      }
      else{
        //System.out.println("Creating");
        data.put(a[i],1);
      }
    }
    //System.out.println("Done Creating");
    for(int i = 0;i< a.length;i++){
      int add = a[i]+k;
      int sub = a[i] - k;
      //System.out.println("Add "+ add+ " Sub"+sub);
      if(data.containsKey(add)){
        //System.out.println("Count ++ on add");
        count = count+data.get(add);
      }
      if(data.containsKey(sub)){
        //System.out.println("Count ++ on sub");
        count = count + data.get(sub);
      }
    }
      
    // count /2 because we are taking the same number 2 times eg 1 and 3 and 3 and 1
        return count/2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}