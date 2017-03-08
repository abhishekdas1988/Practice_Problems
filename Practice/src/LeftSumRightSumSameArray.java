import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// if in array there exists a number where the left sum and right sum of the array are same, print yes
// if there are no numbers to the left or right the sum is taken as 0;
/*
2
3
1 2 3
4
1 2 3 3
 * */
public class LeftSumRightSumSameArray {
  public static String sumExists(int[] a){
    int lsum=0;
    int rsum = 0;
    if(a.length==1){
      return "YES";
    }
    else{
      for(int i =1;i< a.length;i++){
        rsum+=a[i];
      }
      if(lsum==rsum){
        return "YES";
      }
    }
    for(int i = 1;i< a.length;i++){
      lsum +=a[i-1];
      rsum -=a[i];
      if(lsum==rsum){
        return "YES";
      }
    }
    return "NO";
  }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner s = new Scanner(System.in);
      int t_case = Integer.parseInt(s.nextLine());
      String line;
      int [] a;
      for(int i=0;i<t_case;i++){
        int size = Integer.parseInt(s.nextLine());
        line = s.nextLine();
        String[] _line = line.split(" ");
        a = new int[_line.length];
        for(int j = 0;j< _line.length;j++){
          a[j] = Integer.parseInt(_line[j]);
        }
        System.out.println(LeftSumRightSumSameArray.sumExists(a));
      }
    }
}